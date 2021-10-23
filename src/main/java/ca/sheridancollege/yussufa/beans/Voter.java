package ca.sheridancollege.yussufa.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Voter {
	
	private Long id;
	private String name;
	private String candidate;
}
