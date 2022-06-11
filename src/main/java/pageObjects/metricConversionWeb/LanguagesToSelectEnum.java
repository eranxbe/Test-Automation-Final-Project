package pageObjects.metricConversionWeb;

public enum LanguagesToSelectEnum {

    ITALIAN {
        public String toString() {
            return "/it/";
        }
    },
    SPANISH {
        public String toString() {
            return "/es/";
        }
    },
    AFRIKAANS {
        public String toString() {
            return "/af/";
        }
    }

}
