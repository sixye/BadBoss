package com.fox.badboss.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener {

	private static final int REQUESTCODE = 1;
	private EditText mUsername, mPassword;
	private Button mLogin, mRegister;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		findViews();
	}

	private void findViews() {
		// TODO Auto-generated method stub
		mUsername = (EditText) findViewById(R.id.et_username);
		mPassword = (EditText) findViewById(R.id.et_password);
		mLogin = (Button) findViewById(R.id.bt_login);
		mRegister = (Button) findViewById(R.id.bt_register);
		mLogin.setOnClickListener(this);
		mRegister.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bt_login:
			String name = mUsername.getText().toString().trim();
			String passwd = mPassword.getText().toString().trim();
			
			if("123".equals(name) && "123".equals(passwd)){
				startActivity(new Intent(LoginActivity.this,MainActivity.class));
				finish();
			}else if(name.isEmpty()||passwd.isEmpty()){
				Toast.makeText(this, "用户名或密码不能为空！", Toast.LENGTH_SHORT).show();
			}else{
				{
					Toast.makeText(this, "用户名或密码错误！", Toast.LENGTH_SHORT).show();
				}
			}

			break;

		case R.id.bt_register:
			startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
			/*Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
			intent.putExtra("username", "");
			intent.putExtra("password", "");
			startActivityForResult(intent, REQUESTCODE);*/
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	}
}
