package eu.uberdust.mobileclient.slideview;

import android.support.v4.app.FragmentManager;
import eu.uberdust.mobileclient.model.RoomTree;

public class MyTitleFragmentAdapter extends MyFragmentAdapter {
	public MyTitleFragmentAdapter(FragmentManager fm, RoomTree currentRoom, int type) {
		super(fm, currentRoom, type);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return MyFragmentAdapter.CONTENT[position % CONTENT.length];
	}
}