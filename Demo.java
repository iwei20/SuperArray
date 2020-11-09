import java.util.Arrays;

public class Demo {
    public static void removeDuplicates(SuperArray s) {
        for(int i = s.size() - 1; i >= 0; --i) {
            if(i != s.indexOf(s.get(i))) s.remove(i);
        }
    }

    public static SuperArray findOverlap(SuperArray a, SuperArray b) {
        SuperArray result = new SuperArray();
        for(int i = 0; i < a.size(); ++i) {
            if(b.contains(a.get(i))) result.add(a.get(i));
        }
        removeDuplicates(result);
        return result;
    }

    public static SuperArray zip(SuperArray a, SuperArray b) {
        SuperArray result = new SuperArray();
        for(int i = 0; i < Math.max(a.size(), b.size()); ++i) {
            if(i < a.size()) result.add(a.get(i));
            if(i < b.size()) result.add(b.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        SuperArray words = new SuperArray();
        System.out.println(words.isEmpty());
        words.add("kani");
        words.add("uni");
        words.add("ebi");
        for(int i = 0; i < words.size(); i++){
            System.out.println( words.get(i) );
        }

        for(int i = 0; i < 10; ++i) {
            words.add("mhm");
        }
        
        for(int i = 0; i < words.size(); ++i) {
            if(!words.get(i).equals("mhm")) {
                System.out.println("Don't say " + words.set(i, "hmh") + "!");
            }
            System.out.println( words.get(i) );
        }

        System.out.println(words);
        System.out.println(words.contains("hmh"));
        System.out.println(words.contains("mhm"));
        System.out.println(words.contains("m"));

        System.out.println(words.isEmpty());
        System.out.println(words.indexOf("mhm"));
        System.out.println(words.indexOf("hmh"));

        SuperArray empty = new SuperArray(25);
        System.out.println(empty);
        System.out.println(Arrays.toString(empty.toArray()));
        System.out.println(empty.indexOf("ok"));

        SuperArray things = new SuperArray();
        things.add("C");
        things.remove(0);
        System.out.println(things.size());
        things.add("C");
        things.add(0, "A");
        things.add(1, "B");
        System.out.println(things.size());
        String[] independent = things.toArray();
        independent[0] = "the outside changed!";
        System.out.println(Arrays.toString(independent));
        System.out.println(things);
        

        things.clear();
        System.out.println(things.isEmpty());
        things.add("A");
        things.add("A");
        removeDuplicates(things);
        System.out.println(things);
        things.add("A");
        things.add("C");
        things.add("D");

        SuperArray toCompare = new SuperArray();
        toCompare.add("A");
        toCompare.add("A");
        toCompare.add("D");
        System.out.println(toCompare.lastIndexOf("A"));
        System.out.println(toCompare.lastIndexOf("B"));
        System.out.println(findOverlap(things, toCompare));
        System.out.println(findOverlap(things, toCompare).lastIndexOf("D"));
        System.out.println(zip(things, findOverlap(things, toCompare)));
        System.out.println(zip(new SuperArray(), new SuperArray()));
        System.out.println(findOverlap(new SuperArray(), zip(things, new SuperArray())).equals(new SuperArray()));
        System.out.println(zip(things, findOverlap(new SuperArray(), toCompare)).equals(new SuperArray()));

        int errors = 0;
        try{
            SuperArray negative = new SuperArray(-5);
        } catch(IllegalArgumentException e) {
            ++errors;
        }

        try{
            things.set(things.size(), "YEP");
        } catch(IndexOutOfBoundsException e) {
            ++errors;
        }

        try{
            things.set(100000000, "YEP");
        } catch(IndexOutOfBoundsException e) {
            ++errors;
            e.printStackTrace();
        }

        try{
            things.set(-1, "YEP");
        } catch(IndexOutOfBoundsException e) {
            ++errors;
        }

        try{
            things.add(things.size(), "YEP");
        } catch(IndexOutOfBoundsException e) {
            ++errors;
        }

        try{
            things.add(100000000, "YEP");
        } catch(IndexOutOfBoundsException e) {
            ++errors;
        }

        try{
            things.add(-1, "YEP");
        } catch(IndexOutOfBoundsException e) {
            ++errors;
        }

        try{
            System.out.println(things.get(things.size()));
        } catch(IndexOutOfBoundsException e) {
            ++errors;
        }

        try{
            System.out.println(things.get(10000000));
        } catch(IndexOutOfBoundsException e) {
            ++errors;
        }

        try{
            System.out.println(things.get(-1));
        } catch(IndexOutOfBoundsException e) {
            ++errors;
        }

        try{
            things.remove(things.size());
        } catch(IndexOutOfBoundsException e) {
            ++errors;
        }

        try{
            things.remove(100000000);
        } catch(IndexOutOfBoundsException e) {
            ++errors;
        }

        try{
            things.remove(-1);
        } catch(IndexOutOfBoundsException e) {
            ++errors;
        }

        System.out.println(errors + " out of 13 errors");

    }
}
