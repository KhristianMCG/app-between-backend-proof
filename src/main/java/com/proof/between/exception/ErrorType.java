package com.proof.between.exception;

import java.io.Serializable;

public interface ErrorType extends Serializable {

    String getDescription();

    String getCode();
}
