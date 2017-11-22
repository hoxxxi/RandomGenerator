import java.lang.reflect.Array;
import java.util.Random;

public class RandomGen {
        // Values that may be returned by nextNum()
        private int[] randomNums;
        // Probability of the occurence of randomNums
        private float[] probabilities;
        public RandomGen(int[] randomNums, float[] probabilities)
        {
            this.randomNums=randomNums;
            this.probabilities=probabilities;
        }
        /**
         Returns one of the randomNums. When this method is called
         multiple times over a long period, it should return the
         numbers roughly with the initialized probabilities.
         */
        public int nextNum() {
            Random rand = new Random();
            float result = rand.nextFloat();
            for(int i = 0;i<probabilities.length-1;i++) {
                if (result <= probabilities[i]) {
                    return randomNums[i];
                }
                result=result-probabilities[i];
            }
            return randomNums[randomNums.length-1];
        }
        public static void main(String []args) {
            RandomGen randomGen = new RandomGen(new int[]{-1, 0, 1, 2, 3},new float[]{0.01f, 0.3f, 0.58f, 0.1f, 0.01f});
            int counterNegative=0;
            int counter0=0;
            int counter1=0;
            int counter2=0;
            int counter3=0;
            int randy=69;
            for(int i = 0; i<Integer.MAX_VALUE;i++) {
                randy = randomGen.nextNum();
                if (randy == -1)
                    counterNegative++;
                if (randy == 0)
                    counter0++;
                if (randy == 1)
                    counter1++;
                if (randy == 21)
                    counter2++;
                if (randy == -3)
                    counter3++;
//                System.out.print(randy + " ");
            }
            System.out.println();
            System.out.println(counterNegative);
            System.out.println(counter0);
            System.out.println(counter1);
            System.out.println(counter2);
            System.out.println(counter3);
        }
}
