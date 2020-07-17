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

    @Override
    public String toString() {
        return from + ", " + to;
    }

    // Получение интервала-пересечения двух интервалов.
    public double[] getArraysIntersection(Range range) {
        double From = Math.max(range.getFrom(), this.getFrom());
        double To = Math.min(range.getTo(), this.getTo());

        if (From >= To) {
            return null;
        }
        return new double[]{From, To};
    }

    // Получение объединения двух интервалов.
    public Range[] getArraysCombining(Range range) {
        if (this.getTo() >= range.getFrom()) {
            return new Range[]{new Range(this.getFrom(), range.getTo())};
        }

        return new Range[]{new Range(this.getFrom(), this.getTo()), new Range(range.getFrom(), range.getTo())};
    }

    // Получение разности двух интервалов.
    public Range[] getArraysDifference(Range range) {
        // Если второй интервал расположен внутри первого -> 2 новых интервала
        if (this.getFrom() < range.getFrom() && this.getTo() > range.getTo()) {
            return new Range[]{new Range(this.getFrom(), range.getFrom()), new Range(range.getTo(), this.getTo())};
        }

        // Если интервалы пересекаются одним концом -> 1 новый интервал
        if (this.getFrom() < range.getFrom() && this.getTo() <= range.getTo() && this.getTo() > range.getFrom()) {
            return new Range[]{new Range(this.getFrom(), range.getFrom())};
        }

        // Если интервалы пересекаются одним концом -> 1 новый интервал
        if (this.getFrom() >= range.getFrom() && this.getTo() > range.getTo() && this.getFrom() < range.getTo()) {
            return new Range[]{new Range(range.getTo(), this.getTo())};
        }
        // Если интервалы равны или первый интервал лежит внутри второго или интервалы не пересекаются -> новый интервал отсутствует
        return null;
    }
}
