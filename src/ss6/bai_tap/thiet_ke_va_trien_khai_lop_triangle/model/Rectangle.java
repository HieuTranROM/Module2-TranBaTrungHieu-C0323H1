package ss6.bai_tap.thiet_ke_va_trien_khai_lop_triangle.model;

import ss6.bai_tap.thiet_ke_va_trien_khai_lop_triangle.service.IResizeable;

public class Rectangle extends Square implements IResizeable {
        private double width = 1.0;
        private double length = 1.0;

        public Rectangle() {
        }

        public Rectangle(double width, double length) {
            this.width = width;
            this.length = length;
        }

        public Rectangle(double width, double length, String color, boolean filled) {
            super(color, filled);
            this.width = width;
            this.length = length;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public double getArea() {
            return width * this.length;
        }

        public double getPerimeter() {
            return 2 * (width + this.length);
        }

        @Override
        public String toString() {
            return "A Rectangle with width="
                    + getWidth()
                    + " and length="
                    + getLength()
                    + ", which is a subclass of "
                    + super.toString();
        }

        @Override
        public void resize(double percents) {
            this.setLength(this.getLength() * percents);
            this.setWidth(this.getWidth() * percents);
        }
    }

