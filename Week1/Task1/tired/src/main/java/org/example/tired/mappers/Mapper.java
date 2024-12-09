package org.example.tired.mappers;

import java.util.List;

public interface Mapper <A, B> {
    B /*DTO*/mapTo(A/*Entity*/ a);
    A mapFrom(B b);
}
