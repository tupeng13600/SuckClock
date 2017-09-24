package com.tupeng.suckclock.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.tupeng.suckclock.R;
import com.tupeng.suckclock.util.FileUtil;
import com.tupeng.suckclock.util.PermissionUtil;
import com.tupeng.suckclock.util.UploadUtil;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import static com.tupeng.suckclock.constant.Constant.IMG_SELECT_CODE;

@ContentView(R.layout.activity_info_init)
public class InfoInitActivity extends BaseActivity {

    @ViewInject(R.id.iv_avatar)
    ImageView avatarView;

    @ViewInject(R.id.info_ok)
    Button infoOkBtn;

    @ViewInject(R.id.et_birthday)
    EditText birthdayText;

    @ViewInject(R.id.rg_sex)
    RadioGroup sexGroup;

    @ViewInject(R.id.et_nick)
    EditText nickText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Event(R.id.iv_avatar)
    private void onIvAvatar(View view) {
        if(PermissionUtil.grantPermission(this, IMG_SELECT_CODE, Manifest.permission.READ_EXTERNAL_STORAGE)){
            openPhotoList();
        }
    }

    @Event(R.id.info_ok)
    private void onInfoOk(View view) {
        Toast.makeText(this, "确定了按钮啊", Toast.LENGTH_LONG).show();
        Bitmap bitmap = avatarView.getDrawingCache();
//        String avatar = "";
//        if(null != avatarView) {
//            avatar = UploadUtil.upload(FileUtil.toByte(bitmap));
//        }
//        String birthday = birthdayText.getText().toString();
//        RadioButton sexItem = (RadioButton) findViewById(sexGroup.getCheckedRadioButtonId());
//        String sex = sexItem.getText().toString();
//        String nick = nickText.getText().toString();
        Intent intent = new Intent(this, MyClockActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case IMG_SELECT_CODE:
                if (resultCode == RESULT_OK) {
                    try {
                        Uri selectedImage = data.getData();
                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
                        Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                        cursor.moveToFirst();
                        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                        String path = cursor.getString(columnIndex);  //获取照片路径
                        cursor.close();
                        Bitmap bitmap = BitmapFactory.decodeFile(path);
                        avatarView.setImageBitmap(bitmap);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openPhotoList();
        } else {
            Toast.makeText(this, "权限不足", Toast.LENGTH_SHORT).show();
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void openPhotoList(){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, IMG_SELECT_CODE);
    }
}
