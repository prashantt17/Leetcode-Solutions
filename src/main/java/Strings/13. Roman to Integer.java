class Solution {
    public int romanToInt(String s) {
        char[] ch = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < ch.length; i++) {
            String literal = Character.toString(ch[i]);


            if (i < (ch.length - 1)) {
                String adjacentLiteral = Character.toString(ch[i + 1]);
                if (literal.equals("I") && (adjacentLiteral.equals("V") || adjacentLiteral.equals("X"))) {
                    literal += adjacentLiteral;
                } else if (literal.equals("X") && (adjacentLiteral.equals("L") || adjacentLiteral.equals("C"))) {
                    literal += adjacentLiteral;
                }
                if (literal.equals("C") && (adjacentLiteral.equals("D") || adjacentLiteral.equals("M"))) {
                    literal += adjacentLiteral;
                }

            }
            System.out.println(literal);
            switch (literal) {
                case "I":
                    sum += 1;
                    break;
                case "V":
                    sum += 5;
                    break;
                case "X":
                    sum += 10;
                    break;
                case "L":
                    sum += 50;
                    break;
                case "C":
                    sum += 100;
                    break;
                case "D":
                    sum += 500;
                    break;
                case "M":
                    sum += 1000;
                    break;
                case "IV":
                    sum += 4;
                    i++;
                    break;
                case "IX":
                    sum += 9;
                    i++;
                    break;
                case "XL":
                    sum += 40;
                    i++;
                    break;
                case "XC":
                    sum += 90;
                    i++;
                    break;
                case "CD":
                    sum += 400;
                    i++;
                    break;
                case "CM":
                    sum += 900;
                    i++;
                    break;
            }
        }

        return sum;
    }
}
