package roundzero.day68;

import java.util.concurrent.Callable;

interface IBird {
    Egg lay();
}

class Chicken implements IBird {
    boolean eggHatch = false;

    public Chicken() {
    }

    public Egg lay() {
            Egg egg = null;
            try {
                egg = new Egg(new Callable<IBird>() {
                    @Override
                    public IBird call() throws Exception {
                        return new Chicken();
                    }
                });
            } catch (Exception e) {
                throw e;
            }
            return egg;
    }

    public static void main(String[] args) throws Exception {
        Chicken chicken = new Chicken();
        System.out.println(chicken instanceof IBird);
    }
}

class Egg {
    Chicken iBird;

    public Egg(Callable<IBird> createBird) {
        try {
            IBird bird = createBird.call();
            if (bird instanceof Chicken) {
                this.iBird = (Chicken) bird;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public IBird hatch() throws Exception {
        return iBird;
    }
}
