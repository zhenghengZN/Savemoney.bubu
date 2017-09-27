package so.bubu.lib.base.recyclerview.recyclerView.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * description:通用的RecyclerView  adapter
 *
 * Created by wangwn on 2016/4/8.
 */
public abstract class ComRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {
    protected final int mItemLayoutId;
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> list;
    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


    public ComRecyclerViewAdapter(Context context, List<T> mDatas, int itemLayoutId) {
        this.mInflater = LayoutInflater.from (context);
        this.mContext = context;
        this.list = mDatas;
        this.mItemLayoutId = itemLayoutId;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Log.e ("ComRecyclerViewAdapter", "onCreateViewHolder");
        View itemView = mInflater.inflate(mItemLayoutId, parent, false);
        RecyclerViewHolder vh = new RecyclerViewHolder(itemView);
        initItemClickListener(vh);
        return vh;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder viewHolder, int position) {
        convert(viewHolder,list.get(position),position);

    }

    private void initItemClickListener(final RecyclerViewHolder viewHolder) {
        if(mOnItemClickLitener !=null){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = viewHolder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(viewHolder.itemView,list.get(pos), pos);
                }
            });

            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = viewHolder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(viewHolder.itemView,list.get(pos), pos);

                    return false;
                }
            });
        }
    }

    public abstract void convert(RecyclerViewHolder viewHolder, T item,int position);

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    public interface OnItemClickLitener<T>
    {
        void onItemClick(View view, T item, int position);
        void onItemLongClick(View view, T item, int position);
    }
}
