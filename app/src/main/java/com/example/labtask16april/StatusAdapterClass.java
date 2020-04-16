package com.example.labtask16april;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class StatusAdapterClass extends FirestoreRecyclerAdapter<ModelClass,StatusAdapterClass.ViewHolderStatus> {



    public StatusAdapterClass(@NonNull FirestoreRecyclerOptions<ModelClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final ViewHolderStatus viewHolderStatus, int i, @NonNull ModelClass statusModelClass) {

        String username=getSnapshots().getSnapshot(i).getId();
        viewHolderStatus.nameTV.setText(username);
        viewHolderStatus.statusTV.setText(statusModelClass.getStatus());

    }

    @NonNull
    @Override
    public ViewHolderStatus onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        ViewHolderStatus objectViewHolderStatus=new ViewHolderStatus(view);

        return objectViewHolderStatus;
    }

    class ViewHolderStatus extends RecyclerView.ViewHolder
    {

        TextView nameTV,statusTV;
        public ViewHolderStatus(@NonNull View itemView) {
            super(itemView);
            nameTV=itemView.findViewById(R.id.singleRow_nameTV);
            statusTV=itemView.findViewById(R.id.singleRow_statusTV);

        }
    }
}