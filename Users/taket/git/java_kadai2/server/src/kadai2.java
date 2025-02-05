import java.io.*;
import java.lang.reflect.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

class kadai2 {

    public static void main(String[] args) {
        System.out.println("=== 1. メソッドのオーバーロード ===");
        methodOverloadDemo();

        System.out.println("\n=== 2. 文字列操作（大文字変換） ===");
        uppercaseDemo("Hello World!");

        System.out.println("\n=== 3. 文字列の逆順 ===");
        reverseStringDemo("Java Programming");

        System.out.println("\n=== 4. コマンドライン引数 ===");
        if (args.length > 0) {
            System.out.println("こんにちは、" + args[0] + "さん！");
        } else {
            System.out.println("コマンドライン引数がありません。");
        }

        System.out.println("\n=== 5. カスタム例外の作成 ===");
        try {
            checkAgeDemo(16);  // 16歳なので例外が発生
        } catch (InvalidAgeException e) {
            System.out.println("エラー発生: " + e.getMessage());
        }

        System.out.println("\n=== 6. ファイルの読み書き ===");
        fileReadWriteDemo();

        System.out.println("\n=== 7. ArrayList の操作 ===");
        arrayListDemo();

        System.out.println("\n=== 8. HashMap の操作 ===");
        hashMapDemo();

        System.out.println("\n=== 9. Stack の操作 ===");
        stackDemo();

        System.out.println("\n=== 10. Queue の操作 ===");
        queueDemo();

        System.out.println("\n=== 11. Stream の使用 ===");
        streamDemo();

        System.out.println("\n=== 12. ソート ===");
        sortingDemo();

        System.out.println("\n=== 13. ラムダ式 ===");
        lambdaDemo();

        System.out.println("\n=== 14. 現在の日付と時刻 ===");
        currentDateTimeDemo();

        System.out.println("\n=== 15. ファイルの存在確認 ===");
        fileExistenceDemo();

        System.out.println("\n=== 16. マルチスレッドの作成 ===");
        threadDemo();

        System.out.println("\n=== 17. ファイル内の行数を数える ===");
        lineCountDemo();

        System.out.println("\n=== 18. 正規表現で数字を削除 ===");
        regexDemo("Hello123 World456!");

        System.out.println("\n=== 19. リフレクションの使用 ===");
        reflectionDemo();

        System.out.println("\n=== 20. ジェネリクスの利用 ===");
        genericsDemo();
    }

    // --- 1. メソッドのオーバーロード ---
    public static void methodOverloadDemo() {
        MethodOverloadExample moe = new MethodOverloadExample();
        System.out.println("calculate(5) = " + moe.calculate(5));
        System.out.println("calculate(4, 6) = " + moe.calculate(4, 6));
    }

    static class MethodOverloadExample {
        public int calculate(int a) {
            return a * a;
        }
        public int calculate(int a, int b) {
            return a * b;
        }
    }

    // --- 2. 文字列操作（大文字変換） ---
    public static void uppercaseDemo(String input) {
        System.out.println("入力: " + input);
        System.out.println("大文字変換: " + input.toUpperCase());
    }

    // --- 3. 文字列の逆順 ---
    public static void reverseStringDemo(String input) {
        System.out.println("入力: " + input);
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println("逆順: " + reversed);
    }

    // --- 5. カスタム例外の作成 ---
    public static void checkAgeDemo(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("アクセス拒否: 18歳未満のユーザーはアクセスできません。");
        } else {
            System.out.println("アクセス許可: あなたは " + age + " 歳です。");
        }
    }

    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    // --- 6. ファイルの読み書き ---
    public static void fileReadWriteDemo() {
        String fileName = "example.txt";
        String content = "Hello, Java!\nThis is a file example.";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("ファイルに書き込みました: " + fileName);
        } catch (IOException e) {
            System.out.println("書き込みエラー: " + e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("ファイルの内容:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("読み込みエラー: " + e.getMessage());
        }
    }

    // --- 7. ArrayList の操作 ---
    public static void arrayListDemo() {
        ArrayList<String> names = new ArrayList<>();
        names.add("田中");
        names.add("佐藤");
        names.add("久保田");
        names.add("鈴木");
        names.add("河本");
        System.out.println("ArrayListの内容: " + names);
    }

    // --- 8. HashMap の操作 ---
    public static void hashMapDemo() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Java", "プログラミング言語");
        map.put("Spring", "フレームワーク");
        map.put("JUnit", "テストツール");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("キー: " + entry.getKey() + " -> 値: " + entry.getValue());
        }
    }

    // --- 9. Stack の操作 ---
    public static void stackDemo() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("スタックからのポップ結果:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    // --- 10. Queue の操作 ---
    public static void queueDemo() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        queue.offer("D");
        queue.offer("E");
        System.out.println("キューからの取り出し結果:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    // --- 11. Stream の使用 ---
    public static void streamDemo() {
        Integer[] numbers = { 3, 5, 7, 2, 8 };
        List<Integer> multiplied = Arrays.stream(numbers)
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("2を掛けた結果: " + multiplied);
    }

    // --- 12. ソート ---
    public static void sortingDemo() {
        int[] arr = { 5, 2, 8, 3, 9 };
        Arrays.sort(arr);
        System.out.println("昇順にソート: " + Arrays.toString(arr));
    }

    // --- 13. ラムダ式 ---
    public static void lambdaDemo() {
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        System.out.println("2つの整数の積 (5 * 3): " + multiply.apply(5, 3));
    }

    // --- 14. 現在の日付と時刻 ---
    public static void currentDateTimeDemo() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("現在の日付と時刻: " + now.format(formatter));
    }

    // --- 15. ファイルの存在確認 ---
    public static void fileExistenceDemo() {
        File file = new File("test.txt");
        if (file.exists()) {
            System.out.println("ファイルは存在します。");
        } else {
            System.out.println("ファイルは存在しません。");
        }
    }

    // --- 16. マルチスレッドの作成 ---
    public static void threadDemo() {
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hello, World! (" + i + ")");
                try {
                    Thread.sleep(1000); // 1秒待機
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // --- 17. ファイル内の行数を数える ---
    public static void lineCountDemo() {
        String fileName = "example.txt";
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            System.out.println("エラー: " + e.getMessage());
        }
        System.out.println("ファイルの行数: " + count);
    }

    // --- 18. 正規表現で数字を削除 ---
    public static void regexDemo(String input) {
        System.out.println("入力: " + input);
        String result = input.replaceAll("[0-9]", "");
        System.out.println("数字削除後: " + result);
    }

    // --- 19. リフレクションの使用 ---
    public static void reflectionDemo() {
        Class<Person> clazz = Person.class;
        System.out.println("【フィールド一覧】");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(field.getName());
        }
        System.out.println("【メソッド一覧】");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(method.getName());
        }
    }

    // Person クラス（リフレクション用）
    static class Person {
        private String name;
        public int age;

        public Person() {
        }

        public void sayHello() {
            System.out.println("Hello!");
        }

        public void walk() {
            System.out.println("Walking...");
        }
    }

    // --- 20. ジェネリクスの利用 ---
    public static void genericsDemo() {
        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println("整数の値: " + intBox.get());

        Box<String> strBox = new Box<>();
        strBox.set("Hello, Generics!");
        System.out.println("文字列: " + strBox.get());
    }

    // ジェネリック Box クラス
    static class Box<T> {
        private T value;

        public void set(T value) {
            this.value = value;
        }

        public T get() {
            return value;
        }
    }
}
