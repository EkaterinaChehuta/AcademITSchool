package ekaterina.chehuta.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }
    
    public String toString() {
        return "[" + from + ", " + to + "]";
    }

    // Получение интервала-пересечения двух интервалов.
    public Range[] getIntersection(Range range) {
        double from = Math.max(range.from, this.from);
        double to = Math.min(range.to, this.to);

        if (from >= to) {
            return null;
        }

        return new Range[]{new Range(from, to)};
    }

    // Получение объединения двух интервалов.
    public Range[] getUnion(Range range) {
        if (to >= range.from) {
            return new Range[]{new Range(from, range.to)};
        }

        return new Range[]{new Range(from, to), new Range(range.from, range.to)};
    }

    // Получение разности двух интервалов.
    public Range[] getDifference(Range range) {
        // Если второй интервал расположен внутри первого -> 2 новых интервала
        if (from < range.from && to > range.to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        }

        // Если интервалы пересекаются одним концом -> 1 новый интервал
        if (from < range.from && to <= range.to && to > range.from) {
            return new Range[]{new Range(from, range.from)};
        }

        // Если интервалы пересекаются одним концом -> 1 новый интервал
        if (from >= range.from && to > range.to && from < range.to) {
            return new Range[]{new Range(range.to, to)};
        }

        // Если интервалы равны или первый интервал лежит внутри второго или интервалы не пересекаются -> новый интервал отсутствует
        return new Range[]{};
    }
}
