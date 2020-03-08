package client;

import common.*;

interface ClientEventHandler
{
	public void onGetLogonResult(LoginResult result);
	public void onGetRegResult(RegResult result);
	public void onGetAddFriendRequest(AddFriendRequest request);
	public void onGetAddFriendResult(AddFriendResult result);
	public void onChatS2C(Chat chat);
	public void onFriendLogoff(LogoffRequest request);
	public void onFriendLogon(FriendLogin friendLogon);
}

