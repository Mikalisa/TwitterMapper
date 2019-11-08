package filters;

import twitter4j.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * A filter that represents the logical not of its child filter
 */
public class AndFilter implements Filter {
    private final Filter child;
    private final Filter childR;

    public AndFilter(Filter child, Filter s) {

        this.child = child;
        this.childR = s;
    }

    /**
     * A not filter matches when its two children doesn't, and vice versa
     * @param s     the tweet to check
     * @return      whether or not it matches
     */
    @Override
    public boolean matches(Status s) {
        return !child.matches(s) && !childR.matches(s);
    }

    @Override
    public List<String> terms() {
        List<String> terms = new ArrayList<>();
        terms.add(child.toString());
        terms.add(childR.toString());
        return terms;
    }

    public String toString() {
        return "("+child.toString()+" and "+childR.toString()+")";
    }
}
