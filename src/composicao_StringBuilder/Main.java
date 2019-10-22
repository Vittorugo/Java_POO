package composicao_StringBuilder;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		String date = dateFormate.format(new Date());
		
		String title = "Traveing to Nem Zealand";
		String content = "I'm going to visit this wonderful country";
		int likes = 12;
		
		Post post = new Post( dateFormate.parse(date), title, content, likes );
		Comment c1 = new Comment("Have a nice trip! :)");
		Comment c2 = new Comment("Woow that's awesome! *-*");
		
		post.addComment(c1);
		post.addComment(c2);
		
		System.out.println(post);
	}

}
