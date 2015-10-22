package com.fox.badboss.ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//�û�����3-15�����ַ����
//usernameRegex = /^\w{3,15}$/;
//���룺6-12�����ַ����
//passwordRegex = /^\w{6,12}$/;
//���䣺�Լ�ʵ����֤����
//emailRegex = /^\w+@\w+(\.\w+)+$/;
//��ʵ������������2-5����
//realNameRegex = /^[\u4e00-\u9fa5]{2,5}$/;

public class RegisterActivity extends Activity implements OnClickListener {

	private EditText mUsername, mPassword, mRightPassword;
	private EditText mPhoneNumber;
	private EditText mValidate;
	private Button mValidateButton, mRegisterButton;
	private CheckBox mIagreeCB;
	private TextView mProtocol;
	private String username, password, rightpassword, phonenumber, protocol;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		if (savedInstanceState != null) {
			username = savedInstanceState.getString("username");
			password = savedInstanceState.getString("password");
			rightpassword = savedInstanceState.getString("rightpassword");
			phonenumber = savedInstanceState.getString("phonenumber");
			if (username != null || password != null || rightpassword != null || phonenumber != null) {
				mUsername.setText(username);
				mPassword.setText(password);
				mRightPassword.setText(rightpassword);
				mPhoneNumber.setText(phonenumber);
			}
		}
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		mUsername = (EditText) findViewById(R.id.et_username);
		mPassword = (EditText) findViewById(R.id.et_password);
		mRightPassword = (EditText) findViewById(R.id.et_rightpassword);
		mPhoneNumber = (EditText) findViewById(R.id.et_phonenumber);
		mValidate = (EditText) findViewById(R.id.et_validate);

		mValidateButton = (Button) findViewById(R.id.bt_validate);
		mRegisterButton = (Button) findViewById(R.id.bt_register);

		mIagreeCB = (CheckBox) findViewById(R.id.cb_iagree);

		mProtocol = (TextView) findViewById(R.id.tv_protocol);

		mValidateButton.setOnClickListener(this);
		mRegisterButton.setOnClickListener(this);
		mProtocol.setOnClickListener(this);
		mIagreeCB.setOnCheckedChangeListener(new MyListener());
	}
	


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bt_validate:

			username = mUsername.getText().toString().trim();
			password = mPassword.getText().toString().trim();
			rightpassword = mRightPassword.getText().toString().trim();
			phonenumber = mPhoneNumber.getText().toString().trim();
			if ((!password.isEmpty()) && (password.equals(rightpassword))) {
				Toast.makeText(RegisterActivity.this, "������ȷ", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(RegisterActivity.this, "�������벻һ�£���������", Toast.LENGTH_SHORT).show();
			}
			break;

		case R.id.bt_register:

			break;

		case R.id.tv_protocol:
			AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
			dialog.setTitle("�û�ʹ��Э��").setMessage(R.string.protocol);
			dialog.setPositiveButton("�ر�", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub

				}
			});
			dialog.create().show();
			break;
		}
	}

	// �û�ʹ��Э��ѡ��
	public class MyListener implements OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			// TODO Auto-generated method stub
			if (!isChecked) {
				mRegisterButton.setEnabled(false);
			} else {
				mRegisterButton.setEnabled(true);
			}
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putString("username", username);
		outState.putString("password", password);
		outState.putString("rightpassword", rightpassword);
		outState.putString("phonenumber", phonenumber);

	}

	public static boolean isRightPassword(String password, String rightpassword ){
		if(password==rightpassword){
			return true;
		}else{
			return false;
		}
		
	}
	/**
	 * �ж��Ƿ��ǺϷ��ֻ���
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles) {
		// Pattern pattern =
		// Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(18[1,0-1]))\\d{8}$");
		Pattern pattern = Pattern.compile("^1\\d{10}$");
		Matcher m = pattern.matcher(mobiles);
		return m.matches();
	}

	/**
	 * ��֤����������ʽ�Ƿ����
	 * 
	 * @param email
	 * @return �Ƿ�Ϸ�
	 */
	public static boolean isEmail(String email) {
		String emailPattern = "[a-zA-Z0-9][a-zA-Z0-9._-]{2,16}[a-zA-Z0-9]@[a-zA-Z0-9]+.[a-zA-Z0-9]+";
		boolean result = Pattern.matches(emailPattern, email);
		return result;
	}

}
