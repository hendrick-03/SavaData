package ac.mz.savedatearray;

import java.util.ArrayList;

public class DataAcessObject {

    public static class Formdata {
        private static ArrayList<FormData> formData = new ArrayList<>();

        public static void add(FormData data) {
            formData.add(data);
        }

        public static ArrayList<FormData> getFormData() {
            return formData;
        }
    }

}
