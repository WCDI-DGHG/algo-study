import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.Iterator;
import java.util.stream.Collectors;

class Solution {
    // 입력받을 숫자 1의자리수 총 갯수에 대한 배열
    private static int[] countArr = new int[10];
    private static Set<String> set = new ConcurrentSkipListSet<>();

    public static int solution(String numbers) {

        // 자릿수별 숫자개수 할당
        numbers.chars().forEach(v -> countArr[v - 48]++);

        // [입력받은 숫자] 루프
        for (int i = 0; i < numbers.length(); i++) {
            // 루프를 돌며 각각 1자리를 Set에 더해줌
	set.add(numbers.charAt(i) + "");
            Iterator<String> it = set.iterator();
	// Set 의 모든 값들을 돌며
            while (it.hasNext()) {
	    // Set에 현재 있는 값들에 [입력받은 숫자] 각각 1자리들을 붙여줌
                pushToSet(it.next(), numbers);
            }
        }
        // String Set => Integer Set
        Set<Integer> intSet = set.stream().map(v -> Integer.parseInt(v)).collect(Collectors.toSet());
        // Integer Set 에서 소수만 찾아서 개수 리턴
        return (int) intSet.stream().filter(v -> isPrimeNumber(v)).count();
    }

    // Set에 숫자를 넣는 메소드
    private static void pushToSet(String currentValue, String numbers) {
        for (int j = 0; j < numbers.length(); j++) {
            if (checkNumLimit(currentValue + numbers.charAt(j), countArr)) {
	    // 현재 Set에 존재하는 숫자 앞뒤에 숫자한개를 붙임
                set.add(currentValue + numbers.charAt(j));
                set.add(numbers.charAt(j) + currentValue);
            }
        }
    }
    // Set에 넣을 숫자가 넣어도 되는지 체크
    // n : 넣을숫자
    // checkArr : [입력받은 숫자] 자리수별 count
    private static boolean checkNumLimit(String n, int[] checkArr) {
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if (n.chars().filter(v -> c == v).count() > checkArr[c - 48]) {
                return false;
            }
        }
        return true;
    }
    // 소수 찾는 메소드
    private static boolean isPrimeNumber(int n) {
        if (n == 1 || n == 0) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(n); i += 1) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}