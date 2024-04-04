package com.hyquangcuong.commicapp;



import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;


import java.util.List;

public class CommentActivity extends ListActivity {
//    private CommentDao datasource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

//        datasource = new CommentDao(this);
//        datasource.open();
//
//        List<Comment> values = datasource.getAllComments();
//
//        // use the SimpleCursorAdapter to show the
//        // elements in a ListView
//        ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this,
//                android.R.layout.simple_list_item_1, values);
//
//        setListAdapter(adapter);
    }



    // Will be called via the onClick attribute
    // of the buttons in main.xml

//    public void onClick(View view) {
//        @SuppressWarnings("unchecked")
//        ArrayAdapter<Comment> adapter2 = (ArrayAdapter<Comment>) getListAdapter();
//        Comment comment = null;
//
//        switch (view.getId()) {
//            case R.id.btComment:
//                EditText eName = findViewById(R.id.txtComment) ;
//                String cmt = eName.getText().toString();
//
//                // save the new comment to the database
//                comment = datasource.createComment(cmt);
//
//                adapter2.add(comment);
//
//
//                break;
//            case R.id.btDelete:
//                if (getListAdapter().getCount() > 0) {
//                    comment = (Comment) getListAdapter().getItem(0);
//
//                    datasource.deleteComment(comment);
//                    adapter2.remove(comment);
//                }
//                break;
//        }
//        adapter2.notifyDataSetChanged();
//    }
//
//    @Override
//    protected void onResume() {
//        datasource.open();
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        datasource.close();
//        super.onPause();
//    }
//
//}


    //class Comment
        // Database fields
//        private SQLiteDatabase database;
//        private MySQLiteHelper dbHelper;
//
//        private String[] CoLumnComment = {
//                MySQLiteHelper.COLUMN_ID_COMNENT,
//                MySQLiteHelper.COLUMN_COMMENT,
//        };
//
//
//
//        public CommentDao(Context context) {
//            dbHelper = new MySQLiteHelper(context);
//        }
//
//        public void open() throws SQLException {
//            database = dbHelper.getWritableDatabase();
//        }
//
//        public void close() {
//            dbHelper.close();
//        }
//
//
//        public Comment createComment(String comment) {
//            ContentValues values = new ContentValues();
//            values.put(MySQLiteHelper.COLUMN_COMMENT, comment);
//
//            long insertId = database.insert(MySQLiteHelper.TABLE_COMMENT, null,
//                    values);
//            Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENT,
//                    CoLumnComment, MySQLiteHelper.COLUMN_ID_COMNENT + " = " + insertId, null,
//                    null, null, null);
//            cursor.moveToFirst();
//            Comment newComment = cursorToComment(cursor);
//            cursor.close();
//            return newComment;
//        }
//
//
//        public void deleteComment(Comment comment) {
//            long id_comment =  comment.getId();
//            System.out.println("Comment deleted with id: " + id_comment);
//            database.delete(MySQLiteHelper.TABLE_COMMENT, MySQLiteHelper.COLUMN_ID_COMNENT
//                    + " = " + id_comment, null);
//        }
//
//
//
//        public List<Comment> getAllComments() {
//            List<Comment> comments = new ArrayList<Comment>();
//
//            Cursor cursor = database.query(MySQLiteHelper.TABLE_COMMENT,
//                    CoLumnComment, null, null, null, null, null);
//
//            cursor.moveToFirst();
//            while (!cursor.isAfterLast()) {
//                Comment comment = cursorToComment(cursor);
//                comments.add(comment);
//                cursor.moveToNext();
//            }
//            // make sure to close the cursor
//            cursor.close();
//            return comments;
//        }
//
//
//        private Comment cursorToComment(Cursor cursor) {
//            Comment comment = new Comment();
//            comment.setId(cursor.getInt(0));
//            comment.setComment(cursor.getString(1));
//
//            return comment;
//        }


}