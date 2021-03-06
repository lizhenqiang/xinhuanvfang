package com.bigdata.xinhuanufang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bigdata.xinhuanufang.R;
import com.bigdata.xinhuanufang.custom.CircleImageView;
import com.bigdata.xinhuanufang.game.bean.MessageBoardBean;
import com.bigdata.xinhuanufang.utils.Config;
import com.bigdata.xinhuanufang.utils.configUtils;

import org.xutils.x;

import java.util.List;

/*
 * 留言板Adapter
 * */
public class MessageBoardAdapter extends BaseAdapter{
	private Context context;
	private List<MessageBoardBean> fighterOne;
	private LayoutInflater mInflater;

	public MessageBoardAdapter(Context context, List<MessageBoardBean> fighterOne) {
		this.context = context;
		this.fighterOne = fighterOne;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fighterOne.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return fighterOne.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.messageboard_listview_item,
					null);
			holder=new ViewHolder();
			holder.iv_rli_fighterPhoto=(CircleImageView) convertView.findViewById(R.id.iv_rli_fighterPhoto);
			holder.tv_rli_fighterOne=(TextView) convertView.findViewById(R.id.tv_rli_fighterOne);
			holder.tv_rli_fighterTwo=(TextView) convertView.findViewById(R.id.tv_rli_fighterTwo);
			holder.tv_rli_context=(TextView) convertView.findViewById(R.id.tv_rli_context);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		//时间格式转换
		String strTime = configUtils.getStrTimes(fighterOne.get(position).getMessage_date());
		holder.tv_rli_fighterOne.setText(fighterOne.get(position).getUser_username());
		holder.tv_rli_fighterTwo.setText(strTime);
		holder.tv_rli_context.setText(fighterOne.get(position).getMessage_content());
		//加载头像
		if (fighterOne.get(position).getUser_head()!=null) {
			x.image().bind(holder.iv_rli_fighterPhoto, Config.ip+fighterOne.get(position).getUser_head());
		}

		return convertView;

	}
	
	class ViewHolder{
		CircleImageView iv_rli_fighterPhoto;//头像
		TextView tv_rli_fighterOne;//昵称
		TextView tv_rli_fighterTwo;//时间
		TextView tv_rli_context;//评价内容
		
	}
}
