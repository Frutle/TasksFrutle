package com.example.tasksFrutle.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

//модель базы данных
@Entity
public class Task implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int mId;//идентефекатор задания

    @ColumnInfo(name = "text")
    public String mText;//текст задания

    @ColumnInfo(name = "time")
    public int mTime;//время создания

    @ColumnInfo(name = "done")
    public boolean mDone;//рузельтаты работы дела

    public Task()  {
    }


    protected Task(Parcel in) {
        mId = in.readInt();
        mText = in.readString();
        mTime = in.readInt();
        mDone = in.readByte() != 0;
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mText);
        dest.writeInt(mTime);
        dest.writeByte((byte) (mDone ? 1 : 0));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return mId == task.mId &&
                mTime == task.mTime &&
                mDone == task.mDone &&
                Objects.equals(mText, task.mText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mText, mTime, mDone);
    }

}
