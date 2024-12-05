package com.example.team3.client_chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.team3.R;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private List<Message> mMessageList;

    public ChatAdapter(List<Message> messageList) {
        mMessageList = messageList;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_log, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        Message message = mMessageList.get(position);
        holder.mMessageTextView.setText(message.getMessage());
        holder.mTimeTextView.setText(message.getTime());
        holder.mSenderTextView.setText(message.getSender());

        holder.mSenderImageView.setImageResource(R.drawable.person_img);
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();  // 메시지 목록 크기
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        TextView mMessageTextView;
        TextView mTimeTextView;
        TextView mSenderTextView;
        ImageView mSenderImageView;

        public ChatViewHolder(View itemView) {
            super(itemView);
            mMessageTextView = itemView.findViewById(R.id.mesg_Text);
            mTimeTextView = itemView.findViewById(R.id.ch_time);
            mSenderTextView = itemView.findViewById(R.id.ch_id);
            mSenderImageView = itemView.findViewById(R.id.ch_left_image);
        }
    }
}
