# DialogRenameFile
文件重命名库[![](https://jitpack.io/v/EHG613/DialogRenameFile.svg)](https://jitpack.io/#EHG613/DialogRenameFile)
## How to
#### Step 1. Add the JitPack repository to your build file
```
//Add it in your root build.gradle at the end of repositories:
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
#### Step 2. Add the dependency
```
dependencies {
	        implementation 'com.github.EHG613:DialogRenameFile:1.1.0'
	}
```
#### Step 3. Use it in your project
```
        RenameFileEventManager.setEventListener(new SimpleRenameFileEvent() {
                    @Override
                    public void onEmpty() {
                        Toast.makeText(getApplicationContext(), "请输入文件名", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onMax(int maxLength) {
                        Toast.makeText(getApplicationContext(), "最大长度为" + maxLength + "个字", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onRename(String str) {
                        Toast.makeText(getApplicationContext(), "重命名为:" + str, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onRename(String str, String id) {
                        Toast.makeText(getApplicationContext(), "重命名为:" + str + ";ID:" + id, Toast.LENGTH_SHORT).show();
                    }
                });

```
```
        Intent intent = new Intent(this, DialogRenameFile.class);
        intent.putExtra(DialogRenameFile.EXTRA_FILENAME, "123.txt");
        intent.putExtra(DialogRenameFile.EXTRA_ID, "adbcdef");
        intent.putExtra(DialogRenameFile.EXTRA_MAX_LENGTH, 5);//default max length is 50
        startActivity(intent);
```
```
    @Override
    protected void onDestroy() {
        super.onDestroy();
        RenameFileEventManager.unbind();
    }
```
