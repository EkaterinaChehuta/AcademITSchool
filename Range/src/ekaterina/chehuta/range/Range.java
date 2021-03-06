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
    public Range getIntersection(Range range) {
        double newFrom = Math.max(range.from, from);
        double newTo  = Math.min(range.to, to);

        if (newFrom >= newTo) {
            return null;
        }

        return new Range(newFrom, newTo);
    }

    // Получение объединения двух интервалов.
    public Range[] getUnion(Range range) {
        if (from > range.to || to < range.from) {
            return new Range[]{new Range(from, to), new Range(range.from, range.to)};
        }

        return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
    }

    // Получение разности двух интервалов.
    public Range[] getDifference(Range range) {
        if (from >= range.to || to <= range.from) {
            return new Range[]{new Range(from, to)};
        }

        if (from >= range.from) {
            if (to <= range.to) {
                return new Range[]{};
            }

            return new Range[]{new Range(range.to, to)};
        }

        if (to <= range.to) {
            return new Range[]{new Range(from, range.from)};
        }

        return new Range[]{new Range(from, range.from), new Range(range.to, to)};
    }
}