### This shows the "one-to-many" relationship. You can see that some of the characters have more than one row because they have many sounds. How can you see all the info from the characters, actions, and character_actions tables? Here's an example that joins three tables:

    SELECT columns FROM junction_table
    FULL JOIN table_1 ON junction_table.foreign_key_column = table_1.primary_key_column
    FULL JOIN table_2 ON junction_table.foreign_key_column = table_2.primary_key_column;

### Congratulations on making it this far. This is the last step. View all the data from characters, actions, and character_actions by joining all three tables. When you see the data, be sure to check the "many-to_many" relationship. Many characters will have many actions.
