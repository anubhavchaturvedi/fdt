
package ch.ethz.ssh2.packets;


public class PacketUserauthRequestInteractive
{
	byte[] payload;

	String userName;
	String serviceName;
	String[] submethods;

	public PacketUserauthRequestInteractive(String serviceName, String user, String[] submethods)
	{
		this.serviceName = serviceName;
		this.userName = user;
		this.submethods = submethods;
	}

	public byte[] getPayload()
	{
		if (payload == null)
		{
			TypesWriter tw = new TypesWriter();
			tw.writeByte(Packets.SSH_MSG_USERAUTH_REQUEST);
			tw.writeString(userName);
			tw.writeString(serviceName);
			tw.writeString("keyboard-interactive");
			tw.writeString(""); 
			
			tw.writeNameList(submethods);

			payload = tw.getBytes();
		}
		return payload;
	}
}