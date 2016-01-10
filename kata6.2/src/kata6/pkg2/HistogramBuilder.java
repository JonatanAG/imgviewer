package kata62;

import java.util.ArrayList;

public class HistogramBuilder <T> {

    private final ArrayList<T> items;

    public HistogramBuilder(ArrayList<T> item) {
        this.items = item;
    }
    
    public <A> Histogram <A> build (Atribute <T,A> atribute){
        Histogram <A> histogram = new Histogram<>();
        for (T item : items) {
            A value = atribute.get(item);
            histogram.increment(value);
        }
        return histogram;
    }
}
