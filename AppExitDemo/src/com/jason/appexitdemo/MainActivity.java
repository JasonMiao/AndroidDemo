package com.jason.appexitdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	/*
	 * 创建对话框
	 */
	protected void createDialog() {
		// 初始化AlertDialog构造器对象
		AlertDialog.Builder builder = new Builder(MainActivity.this);
		// 设置对话框内容
		builder.setMessage("确认退出吗？");
		// 设置对话框标题
		builder.setTitle("提示");
		builder.setPositiveButton("确认", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// 确认退出 则对话框消失，程序退出
				dialog.dismiss();
				// finish是把当前Activity从程序栈中取出来，结束掉，然后显示程序栈下面的页面
				// MainActivity.this.finish();
				// 如果程序中有多个Activity打开，要想结束程序则需要使用结束程序的进程ID或者终止当前程序的虚拟机的方式
				// android.os.Process.killProcess(android.os.Process.myPid());
				java.lang.System.exit(0);
			}
		});
		builder.setNegativeButton("取消", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int arg1) {
				// 取消退出则只需要让对话框消失即可
				dialog.dismiss();
			}
		});
		// 创建对话框并显示
		builder.create().show();
	}

	/**
	 * 监听返回键事件
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			createDialog();
		}
		return false;
	}
}
