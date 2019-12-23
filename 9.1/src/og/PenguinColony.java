package og;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class PenguinColony {

    private HashSet<Penguin> penguins;

    public PenguinColony(HashSet<Penguin> penguins) {
        this.penguins = penguins;
    }

    public HashSet<Penguin> getPenguins() {
        return penguins;
    }

    public void setPenguins(HashSet<Penguin> penguins) {
        this.penguins = penguins;
    }

    public void uniteColonies(PenguinColony otherColony) {
        HashSet<Penguin> tmp = this.getPenguins();
        HashSet<Penguin> parameter = otherColony.getPenguins();
        while (parameter.size() != 0){
            Penguin pTmp = parameter.iterator().next();
            tmp.add(pTmp);
            parameter.remove(pTmp);
        }
        this.setPenguins(tmp);
        otherColony.setPenguins(parameter);
    }

    public PenguinColony splitColony(Predicate<? super Penguin> pred) {
        // TODO
        HashSet<Penguin> nhs = new HashSet<>();
        HashSet<Penguin> tmp = getPenguins();
        while (tmp.iterator().hasNext()){
            Penguin pTmp = tmp.iterator().next();
            if(pred.test(pTmp)){
                nhs.add(pTmp);
                tmp.remove(pTmp);
            }
        }
        setPenguins(tmp);
        return new PenguinColony(nhs);
    }

    // Bu fonksiyonda penguinFriends listesinden gelen penguenin bizim hashset'te de oldugundan emin olmak gerekiyor. direk get(0) ile aldigimiz penguen hashset'te olmama ihtimali var mi? o durumda hashset'te olan ilk pengueni dondurmemiz gerekiyor. 
    public Penguin findFirstFriend(LinkedList<Penguin> penguinFriends) {
        // TODO
        if(penguinFriends.size() > 0){
            return penguinFriends.get(0);
        }
        else{
            return null;
        }

    }

    public boolean canFeedPenguinsWithProperty(Predicate<? super Penguin> pred, Set<Fish> fishes) {
        // TODO
        boolean conn = true;
        while (fishes.iterator().hasNext()){
            Fish a = fishes.iterator().next();
            HashSet<Penguin> tmp = getPenguins();
            while (tmp.iterator().hasNext()){
                Penguin pTmp = tmp.iterator().next();
                if(pred.test(pTmp)){
                    conn = false;
                    break;
                }
            }
        }
        return conn;
    }

    public int computeSum(Function<? super Penguin, Integer> fun) {
        // TODO
        int sum = 0;
        HashSet<Penguin> tmp = getPenguins();
        while (tmp.iterator().hasNext()){
            Penguin pTmp = tmp.iterator().next();
            sum += fun.apply(pTmp);
        }
        return sum;
    }

}
