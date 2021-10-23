# Voting-App

Basic SpringBoot app interacting with an H2-database .This system is used for the election of two candidates Kodos and Kang.
This app will allow users to vote for Kang or Kodos.
All a voter has to do is provide their name and their vote. The user’s name along with who they voted for will be stored in H2. Their ID is also be stored in H2 but this value is auto-generated.
Any voter whose name ends in the letter “z”, their vote goes to Kodos even if they voted for Kang.
Any voter who has a name length that is more than 8 characters long gets Kang’s vote up by 2!
