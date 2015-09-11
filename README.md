# Counted-Splitting
splits from one list and sort it in the another list. 
Given N names. Each name has first name and last name. Task is to split the N names into two lists. Insert all the names in to the first list. Move kth name from the middle
position of the first list to the second list. Once you move a name from the first list to the second, the middle name may change. Again you move kth name from the middle position of the
remaining first list to the second list. Repeat this process till there is only one name remains in the first list. Move the names to second list such that all the names are ordered in descending
order by their Last Name.
If N is even number then middle position is integer division N/2.
If N is odd number then middle position is 1+integer division N/2.
