package sg.edu.rp.c346.id22021506.song;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context=".SecondActivity" >

<Button
        android:id="@+id/btnShow5Stars"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="@string/btn5stars"  />

<Spinner
        android:id="@+id/spinnerYear"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_gravity="center_horizontal"
                android:visibility="visible" />

<ListView
        android:id="@+id/lv"
                android:layout_width="match_parent"
                android:layout_height="wrap_content" >
</ListView>
</LinearLayout>
