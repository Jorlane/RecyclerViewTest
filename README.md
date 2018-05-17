# RecyclerViewTest
This project example shows how you can include items at the top or bottom in a RecyclerView.
I used a LinkedList (it`s a double linked queue) to do this (see the code above and in the Adapter AdapterTest)
My husband Anderson Berlim Melo gave me the idea to use a double linked queue.

Important: the method notifyItemInserted - used in adapter - can't be called while RecyclerView is scrolling. Then, my suggestion is to verify scrollState == RecyclerView.SCROLL_STATE_IDLE.
