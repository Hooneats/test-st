import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StreamTest {

    //Function , Consumer(소비->최종), Supplier, Predicate, Comparator


    public static void main(String[] args) {
        List<String> dummyDatas = new ArrayList();

        dummyDatas.add("나루토이다");
        dummyDatas.add("사쿠라..");
        dummyDatas.add("보루토");
        dummyDatas.add("사스케님");
        dummyDatas.add("카카시");
        dummyDatas.add("이타치");


        // ver 1
        Map<Integer, String> maps = new HashMap<>();
        if (dummyDatas != null && dummyDatas.size() != 0) {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            dummyDatas.forEach(s -> {
                if (s.contains("토") && (s.length() == 3) && s.contains("보") ) {
                    maps.put(atomicInteger.getAndIncrement(), s);
                }
            });
        }


        // ver 2
        // filter, map, foreach
        AtomicInteger atomicInteger2 = new AtomicInteger(0);
        Map<Integer, String> map2 =
                dummyDatas.stream()
                .filter(c -> c.contains("토"))
                .filter(c -> c.length() == 3)
                .filter(c -> c.contains("보"))
                .collect(Collectors.toMap(s -> atomicInteger2.getAndIncrement(), o -> o));



        String aa = "asd";
        Optional.ofNullable(aa)
                .filter(s -> s.contains("a"))
                .ifPresent(System.out::println);
    }

}
