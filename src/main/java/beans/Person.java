package beans;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Person {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int age;

    public static Person parsePerson(String s) {
        String[] t = s.split(" ");
        return new Person(Integer.parseInt(t[0]), t[1], Integer.parseInt(t[2]));
    }
}
