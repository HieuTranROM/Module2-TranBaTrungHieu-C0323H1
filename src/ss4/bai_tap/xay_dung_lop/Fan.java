package ss4.bai_tap.xay_dung_lop;

    public class Fan {
        private final int SLOW = 1;
        private final int MEDIUM = 2;
        private final int FAST = 3;
        private int speed;
        private boolean on;
        private double radius;
        private String color;

        public int getSLOW() {
            return SLOW;
        }

        public int getMEDIUM() {
            return MEDIUM;
        }

        public int getFAST() {
            return FAST;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public boolean isOn() {
            return on;
        }

        public void setOn(boolean on) {
            this.on = on;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Fan() {
            speed = SLOW;
            radius = 5.0;
            color = "Blue";
        }

        public Fan(int speed, boolean on, double radius, String color) {
            this.speed = speed;
            this.on = on;
            this.radius = radius;
            this.color = color;
        }

        public String to_string() {
            String result = "";
            if (isOn()) {
                result = "Speed: " + speed + ", color: " + color + ", radius: " + radius + ". Fan is on.";
                return result;
            } else {
                result = "Color: " + color + ", radius: " + radius + ". Fan is off.";
                return result;
            }
        }
    }






