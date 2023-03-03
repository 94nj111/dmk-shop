package com.example.dmk.common;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ApplicationConstants {
  @UtilityClass
  public class Types{
    public static final String PRODUCTS = """
        {"types": ["ШТАНИ",
                   "ВЗУТТЯ",
                   "ФУТБОЛКИ_СОРОЧКИ",
                   "ВЕРХНІЙ_ОДЯГ",
                   "АКСЕСУАРИ"]
        }""";
    public static final String DELIVERY = """
                {"types": ["САМОВИВІЗ",
                           "ДОСТАВКА"]
            }""";
  }

}
