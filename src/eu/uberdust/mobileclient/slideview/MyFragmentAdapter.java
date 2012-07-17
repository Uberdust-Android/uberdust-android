package eu.uberdust.mobileclient.slideview;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import eu.uberdust.mobileclient.model.Capability;
import eu.uberdust.mobileclient.model.NodeTree;
import eu.uberdust.mobileclient.model.RoomTree;

public class MyFragmentAdapter extends FragmentPagerAdapter {
	protected static String[]  CONTENT;
	private ArrayList<Capability> listcap = new ArrayList<Capability>();
	private ArrayList<NodeTree> listnode = new ArrayList<NodeTree>();
	private int typep =0;
	private int mCount = 0;

	public MyFragmentAdapter(FragmentManager fm, RoomTree currentRoom, int type) {
		super(fm);
		
		typep=type;
		
		switch(type){
			case 0:{
				for(int i=0;i<currentRoom.getNodenum();i++){
					for(int j=0;j<currentRoom.getNode(i).getCapabilitiesNum();j++){
						mCount++;
						listnode.add(currentRoom.getNode(i));
						listcap.add(currentRoom.getNode(i).getCapability(j));
				
					}
				}
		
				CONTENT = new String[mCount];
				for(int i=0;i<mCount;i++){
					CONTENT[i]= listcap.get(i).getAttribute();
				}
				break;
			}
			
			case 1:{
				for(int i=0;i<currentRoom.getNodenum();i++){
					for(int j=0;j<currentRoom.getNode(i).getCapabilitiesNum();j++){
						mCount++;
						listnode.add(currentRoom.getNode(i));
						listcap.add(currentRoom.getNode(i).getCapability(j));
				
					}
				}
		
				CONTENT = new String[mCount];
				for(int i=0;i<mCount;i++){
					CONTENT[i]= listcap.get(i).getAttribute();
				}
				break;
			}
			
			case 2:{
				CONTENT = new String[] { "History", "Graph", };
				mCount = CONTENT.length;
				break;
			}
		}
	} 

	@Override
	public Fragment getItem(int position) {
		switch(typep){
			case 0: return MyCapabilitiesFragment.newInstance(listcap.get(position) , listnode.get(position).getName());
			case 1: return MyCommandFragment.newInstance(listcap.get(position) , listnode.get(position).getName());
			case 2: return MyHistoryFragment.newInstance(CONTENT[position % CONTENT.length]);
		}
		return null;
		
	}

	@Override
	public int getCount() {
		return mCount;
	}
	
	public void setCount(int count) {
		if (count > 0 && count <= 10) {
			mCount = count;
			notifyDataSetChanged();
		}
	}
}