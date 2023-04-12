package ac.mz.savedatearray;

import android.os.Parcel;
import android.os.Parcelable;

public class FormData implements Parcelable {

    private String nome, pass, data;

    public FormData(String nome, String pass, String data) {
        this.nome = nome;
        this.pass = pass;
        this.data = data;
    }

    protected FormData(Parcel in) {
        nome = in.readString();
        pass = in.readString();
        data = in.readString();
    }

    public static final Creator<FormData> CREATOR = new Creator<FormData>() {
        @Override
        public FormData createFromParcel(Parcel in) {
            return new FormData(in);
        }

        @Override
        public FormData[] newArray(int size) {
            return new FormData[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(pass);
        dest.writeString(data);
    }
}


