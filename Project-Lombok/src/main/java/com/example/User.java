package com.example;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor // only generates constructor with final and non-null fields since they are "required"
@AllArgsConstructor
@EqualsAndHashCode
//@ToString(includeFieldNames=false)
@ToString(onlyExplicitlyIncluded=true)
public class User {
//    private final String id;
    @ToString.Include
    private String name;
    @Setter(AccessLevel.NONE)
//    @ToString.Exclude
    private String phone;
    //    @Getter(AccessLevel.PRIVATE) @Setter(AccessLevel.PROTECTED)
    private static int DUMMY = 50;

    @NonNull private String age;
//    public User(String id) {
//        this.id = id;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof User)) return false;
//        User userObj = (User) obj;
//        if (userObj == this) return true;
//        return this.name.equals(userObj.name);
//    }
//
//    @Override
//    public int hashCode(){
//        return Objects.hash(name, phone);
//    }
}
