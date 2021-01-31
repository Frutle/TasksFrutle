package com.example.tasksFrutle;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import com.example.tasksFrutle.Model.Task;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Holder> {

    private SortedList<Task> mSortedList;

    public Adapter() {
        mSortedList = new SortedList<>(Task.class, new SortedList.Callback<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if(o1.mDone && !o2.mDone){
                    return 1;
                }
                if(!o1.mDone && o2.mDone){
                    return -1;
                }
                return (o1.mTime-o2.mTime);
            }

            @Override
            public void onChanged(int position, int count) {
                notifyItemRangeChanged(position,count);
            }

            @Override
            public boolean areContentsTheSame(Task oldItem, Task newItem) {
                return oldItem.equals(newItem);
            }

            @Override
            public boolean areItemsTheSame(Task item1, Task item2) {
                return item1.mId == item2.mId;
            }

            @Override
            public void onInserted(int position, int count) {
                notifyItemRangeInserted(position, count);
            }

            @Override
            public void onRemoved(int position, int count) {
                notifyItemRangeRemoved(position, count);
            }

            @Override
            public void onMoved(int fromPosition, int toPosition) {
                notifyItemMoved(fromPosition, toPosition);
            }
        });
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(mSortedList.get(position));
    }

    @Override
    public int getItemCount() {
        return mSortedList.size();
    }

    public void setItems(List<Task> task) {
        mSortedList.replaceAll(task);
    }

}
