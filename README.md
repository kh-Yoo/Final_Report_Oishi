# Andante Team Final Report
## 목차  
1. 프로젝트 개요  
2. 프로젝트 목표  
3. 개발 환경  
4. 애플리케이션 소개
5. 구현 동영상  
6. 사용기술
7. 개선방안  

## 1. 프로젝트 개요  
**프로젝트 주제 선정 이유**

성공 앱에 대한 분석을 하는 중에 배달의민족에 대해 조사를 하게 되었다.  
배달음식시장 규모가 20조원으로 증가했으며, 이 중 배달의민족이 1/4을 차지하며 업계 1위를 달성하였다.  
코로나19 영향으로 배달음식 수요가 증가함에 따라 매출은 전년보다 더 증가할 것으로 예측된다.  
고객들이 많이 사용하는 앱일수록 고객들의 니즈를 파악하여 앱을 유지보수하는 것이 중요하다고 생각했다.

![배민성장률](https://user-images.githubusercontent.com/62701551/85105330-4cd90500-b245-11ea-92c4-1050d5a1c57c.png)

## 2. 프로젝트 목표

배달의민족 앱을 사용하는 고객들의 불편한 점이나 개선되었으면 하는 점을 조사하게 되었고 우리 팀이 발견한 불편한 점은 리뷰에 관한 것이었다.

![배민](https://user-images.githubusercontent.com/62701551/85108303-6e88bb00-b24a-11ea-8ca1-b3781d0d47bf.png)

위 사진과 같이 현재 배달의 민족 리뷰창에는 카테고리가 최신순, 별점높은순, 별점낮은순으로 되어있다.  
일반적으로 고객들이 리뷰를 볼때 자신이 주문하고자 하는 메뉴에 관한 리뷰를 보고싶어한다.  
예를 들면, A치킨집에서 양념치킨이 먹고 싶어 양념 치킨에 대한 리뷰를 보고 싶은데 일일이 손으로 스크롤을 내려 양념치킨에 대한 리뷰를 찾아봐야하는 번거로움이 있다.  
우리는 이러한 문제점을 개선하고자 리뷰창에 메뉴별로 볼 수 있게끔 카테고리를 추가하고자 한다.  

![치킨 메뉴별](https://user-images.githubusercontent.com/62701551/85109519-6d588d80-b24c-11ea-8237-6e49b3268101.png)

추가적으로, 치킨 카테고리를 보면 각 브랜드 별로 브랜드를 대표하는 대표메뉴가 있다.  
교촌치킨 - 교촌 허니콤보, BHC - 뿌링클, BBQ - 황금올리브 등 브랜드마다 특색있는 메뉴가 있다.  
이러한 점을 이용하여 브랜드별 / 메뉴별 카테고리를 추가하여 고객들이 주문할때 좀 더 편리하게 주문할 수 있게 하고자 한다.  

## 3. 개발 환경

![phplogo](https://user-images.githubusercontent.com/62701551/85113128-c37bff80-b251-11ea-9bbf-78147e9a5830.png) 

phpMyAdmin  

![androidlogo](https://user-images.githubusercontent.com/62701551/85113140-c676f000-b251-11ea-8863-d20db586a409.png)  

androidstudio  

![자바](https://user-images.githubusercontent.com/62701551/85309928-4caf6280-b4ee-11ea-9580-e3d5099bea47.png)    

Java  

![brackets](https://user-images.githubusercontent.com/62701551/85322023-9f921580-b500-11ea-9988-45df4fc82bec.png)   

Brackets  

![filezilla](https://user-images.githubusercontent.com/62701551/85322029-a15bd900-b500-11ea-8d4d-c008d2b5614c.png)   

FileZilla   

## 4. 애플리케이션 소개  
이 애플리케이션은 배달의민족을 사용하면서 개선되었으면 하는 부분을 개선하였다.   
리뷰창을 세분화하여 고객이 원하는 음식의 리뷰를 꼼꼼하게 확인한 후 주문할 수 있다.  
음식 카테고리 별로 브랜드 / 메뉴별로 구분하여 음식 주문에 더 용이하다.

**4.1 로고 소개**  
오이시(Oishi)는 오늘 이거 시켜먹을까의 줄임말로 '맛있다'의 일본어인 오이시(おいしい)와 동음으로 중의적인 뜻을 가진다.     
고객들이 맛있는 음식을 주문하기를 바라는 마음을 담아 지은 로고이다.     
![oish_logo](https://user-images.githubusercontent.com/62701551/85263230-d25cef00-b4a9-11ea-8332-aa61aaa6c4c6.png)

**4.2 스플래쉬**  
이미지 클릭 ▼   
[![스플래쉬](https://img.youtube.com/vi/NvPZMBDKh7Y/0.jpg)](https://www.youtube.com/watch?v=NvPZMBDKh7Y)

**4.3 초기화면**   
![오이시11](https://user-images.githubusercontent.com/62701551/85307659-23410780-b4eb-11ea-84d0-8d95d6c8bcbb.png) 
![오이시22](https://user-images.githubusercontent.com/62701551/85307664-24723480-b4eb-11ea-8da5-065597a2e0f7.png)  

## 5. 구현 동영상
[오이시 어플 실행](https://youtu.be/UGsIoWY1kjA)    
[리뷰 등록](https://youtu.be/i7R_uju76aw)    


## 6. 사용기술

**php**   
![login_register](https://user-images.githubusercontent.com/62701551/85533456-8184fc00-b64b-11ea-920c-eb7d63de47e5.JPG)    
login.php는 앱 화면에서 입력한 아이디와 비밀번호의 값을 받아 저희가 호스팅한 ykh3587@dothome.co.kr에 연결되어 저장된 데이터베이스에 값이 등록된 아이디와 비밀번호가 같다면 로그인을 합니다.

register.php는 앱 화면에 있는 입력한 값들을 ykh3587@dothome.co.kr에 연결해서 데이터베이스에 저장되도록 해줍니다.

findID.php와 findPW.php는 입력받은 이메일에 전송되어진 인증번호가 맞다면 데이터베이스에서 사용자의 id와 password를 가져와서 showme.php가 보여주도록 해주는 기능입니다.

![storephp](https://user-images.githubusercontent.com/62701551/85533477-8649b000-b64b-11ea-8c5b-4f7b8d6a59dd.JPG)    
각각의 음식점들의 이름들을 php 파일로 해서 자바코드에서 음식에 따른 php를 입력하도록 연결합니다. 그러면 데이터베이스에 있는 가게들의 내부 정보들을 가져와서 보여주도록 해줍니다.

![review](https://user-images.githubusercontent.com/62701551/85533485-877add00-b64b-11ea-91fd-698edbe6d21c.JPG)    
리뷰에 관한 php들은 데이터베이스에 저장된 음식에 관한 리뷰들을 불러오도록 도와주고 리뷰를 작성하도록 합니다.

![userinfo](https://user-images.githubusercontent.com/62701551/85533487-877add00-b64b-11ea-9bbb-36c8a812e62a.JPG)    
user_info에 관한 php들은 사용자의 핸드폰번호와 주소, 사용자의 핸드폰 serial 넘버를 입력받아 데이터베이스에 저장되게 하고 구매하는 단계에서 그 값들을 받아와 보여주도록 해주는 역할입니다.

![shoppingbasket](https://user-images.githubusercontent.com/62701551/85533490-88137380-b64b-11ea-82fe-d638a63079d5.JPG)    
장바구니에 관한 php는 사용자가 선택한 물품을 데이터베이스에 저장해서 장바구니에 들어갔을 때 데이터베이스에 저장된 장바구니 물품들을 가져오고 구매가 끝나거나 장바구니 물품을 제거할 때 사용되도록 했습니다.

**JAVA 코드**

<pre><code>
*LoginActivity*
public class LoginActivity extends AppCompatActivity {

    String txtId;
    MaterialEditText id_Text, password_Text;
    CheckBox login_Checkbox;
    Button login_Button;
    TextView register_Button, search_id_Button, search_password_Button;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //***********************************************************************************************
        //로그인 창에서 회원가입 및 아이디, 비밀번호 찾기와 로그인 성공 시 mainactivity로 이동해주도록 합니다.
        final Intent[] intent = new Intent[3];
        intent[0] = new Intent(LoginActivity.this, MainActivity.class);
        intent[1] = new Intent(LoginActivity.this, RegisterActivity.class);
        intent[2] = new Intent(LoginActivity.this, FindActivity.class);

        id_Text = findViewById(R.id.id_Text);
        password_Text = findViewById(R.id.password_Text);
        login_Checkbox = findViewById(R.id.login_Checkbox);
        login_Button = findViewById(R.id.login_Button);
        register_Button = findViewById(R.id.register_Button);
        search_id_Button = findViewById(R.id.search_id_Button);
        search_password_Button = findViewById(R.id.search_password_Button);
        //***********************************************************************************************
        //로그인 할 아이디와 비밀번호를 저장해서 다음에 접속할 때에도 자동로그인 기능입니다.
        sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        String loginStatus = sharedPreferences.getString(getResources().getString(R.string.prefLoginState), "");
        if (loginStatus.equals("log-in")) {
            startActivity(intent[0]);
            LoginActivity.this.finish();
        }


        register_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent[1]);
            }
        });

        //***********************************************************************************************
        //로그인 버튼을 클릭하면 등록된 아이디와 비밀번호가 맞는 지 http://ykh3587.dothome.co.kr/login.php로 데이터베이스를 연결합니다.
        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                txtId = id_Text.getText().toString();
                String txtPassword = password_Text.getText().toString();
                if (TextUtils.isEmpty(txtId) || TextUtils.isEmpty(txtPassword)) {
                    Toast.makeText(LoginActivity.this, "빈칸을 채워 주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    String url = "http://ykh3587.dothome.co.kr/login.php";

                    ContentValues values = new ContentValues();
                    values.put("userid", txtId);
                    values.put("password", txtPassword);
                    Context context = getApplicationContext();
                    String local = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                    values.put("local", local);
                    BackgroundTask task = new BackgroundTask(url, values);
                    task.execute();
                }
            }
        });

        search_id_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent[2].putExtra("type", getString(R.string.find_id));
                startActivity(intent[2]);
            }
        });

        search_password_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent[2].putExtra("type", getString(R.string.find_password));
                startActivity(intent[2]);
            }
        });
    }

    public class BackgroundTask extends AsyncTask<Void, Void, String> {
        ProgressDialog asyncDialog;

        String url;
        ContentValues values;

        BackgroundTask(String url, ContentValues values) {
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            asyncDialog = ProgressDialog.show(LoginActivity.this, "Please Wait", null, true, true);
        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result;
        }

        //다운로드 중 프로그레스바 업데이트
        @Override
        protected void onProgressUpdate(Void ... voids) {
            super.onProgressUpdate(voids);
        }

        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);
            asyncDialog.dismiss();

            if (results.equals("Login Success")) {
                Toast.makeText(LoginActivity.this, "로그인 성공!", Toast.LENGTH_SHORT).show();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (login_Checkbox.isChecked()) {
                    editor.putString(getResources().getString(R.string.prefLoginState), "log-in");
                }
                else {
                    editor.putString(getResources().getString(R.string.prefLoginState), "log-out");
                }
                editor.apply();

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                LoginActivity.this.finish();
            }

            else {
                Toast.makeText(LoginActivity.this, results, Toast.LENGTH_SHORT).show();
            }
        }
    }
}


*FindActivity*
public class FindActivity extends AppCompatActivity {

    TextView title_Text;
    TabLayout tabs_Layout;
    LinearLayout find_id_Content, find_password_Content;
    MaterialEditText find_id_by_email_Text, find_pw_by_id_Text, find_pw_by_email_Text;
    Button find_id_Button, find_pw_Button;

    Random rand = new Random();
    int emailcode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        Intent intent = getIntent();
        String type = intent.getExtras().getString("type");

        title_Text = findViewById(R.id.title_Text);
        tabs_Layout = findViewById(R.id.tabs_Layout);
        find_id_Content = findViewById(R.id.find_id_Content);
        find_password_Content = findViewById(R.id.find_password_Content);
        find_id_by_email_Text = findViewById(R.id.find_id_by_email_Text);
        find_pw_by_id_Text = findViewById(R.id.find_pw_by_id_Text);
        find_pw_by_email_Text = findViewById(R.id.find_pw_by_email_Text);
        find_id_Button = findViewById(R.id.find_id_Button);
        find_pw_Button = findViewById(R.id.find_pw_Button);

        //아이디찾기로 들어오면 아이디찾기 출력
        if (Objects.equals(type, getString(R.string.find_id))) {
            title_Text.setText(type);
            find_id_Content.setVisibility(View.VISIBLE);
            find_password_Content.setVisibility(View.INVISIBLE);
        }
        //비밀번호찾기로 들어오면 비밀번호찾기 출력
        else if (Objects.equals(type, getString(R.string.find_password))) {
            title_Text.setText(type);
            find_id_Content.setVisibility(View.INVISIBLE);
            find_password_Content.setVisibility(View.VISIBLE);
        }

        tabs_Layout.addTab(tabs_Layout.newTab().setText(getString(R.string.find_id)));
        tabs_Layout.addTab(tabs_Layout.newTab().setText(getString(R.string.find_password)));
        tabs_Layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                changeView(pos);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //***********************************************************************************************
        //로그인 http://ykh3587.dothome.co.kr/findID.php로 연결한 후에 데이터 베이스에 있는 이메일과 입력된 이메일이 같다면 인증번호를 보내줍니다.
        find_id_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtEmail = find_id_by_email_Text.getText().toString();

                if (android.os.Build.VERSION.SDK_INT > 9) {

                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();

                    StrictMode.setThreadPolicy(policy);
                }
                if (!isEmail(txtEmail)) {
                    Toast.makeText(FindActivity.this, "이메일 형식이 아닙니다", Toast.LENGTH_SHORT).show();
                }
                else {
                    String type = getString(R.string.find_id);

                    String url = "http://ykh3587.dothome.co.kr/findID.php";

                    ContentValues values = new ContentValues();
                    values.put("email", txtEmail);

                    BackgroundTask task = new BackgroundTask(url, values, type);
                    task.execute();
                }
            }
        });

        //***********************************************************************************************
        //로그인 http://ykh3587.dothome.co.kr/findID.php로 연결한 후에 데이터 베이스에 있는 이메일, 아이디와 입력된 이메일, 아이디가 같다면 인증번호를 보내줍니다.
        find_pw_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtId = find_pw_by_id_Text.getText().toString();
                String txtEmail = find_pw_by_email_Text.getText().toString();

                if (!isEmail(txtEmail)) {
                    Toast.makeText(FindActivity.this, "이메일 형식이 아닙니다", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(txtId)){
                    Toast.makeText(FindActivity.this, "ID를 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    String type = getString(R.string.find_password);

                    String url = "http://ykh3587.dothome.co.kr/findPW.php";

                    ContentValues values = new ContentValues();
                    values.put("userid", txtId);
                    values.put("email", txtEmail);

                    BackgroundTask task = new BackgroundTask(url, values, type);
                    task.execute();
                }
            }
        });
    }

    private void changeView(int index) {
        switch (index) {
            case 0:
                title_Text.setText(getString(R.string.find_id));
                find_id_Content.setVisibility(View.VISIBLE);
                find_password_Content.setVisibility(View.INVISIBLE);
                break;
            case 1:
                title_Text.setText(getString(R.string.find_password));
                find_id_Content.setVisibility(View.INVISIBLE);
                find_password_Content.setVisibility(View.VISIBLE);
                break;
        }
    }

    public static boolean isEmail(String email) {
        boolean returnValue = false;
        String regex = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if (m.matches()) {
            returnValue = true;
        }
        return returnValue;
    }

    public class BackgroundTask extends AsyncTask<Void, Void, String> {
        ProgressDialog asyncDialog;

        String url;
        ContentValues values;
        String type;

        BackgroundTask(String url, ContentValues values, String type) {
            this.url = url;
            this.values = values;
            this.type = type;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            asyncDialog = ProgressDialog.show(FindActivity.this, "Please Wait", null, false, false);
        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result;
        }

        //다운로드 중 프로그레스바 업데이트
        @Override
        protected void onProgressUpdate(Void ... voids) {
            super.onProgressUpdate(voids);
        }

        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);

            //***********************************************************************************************
            //입력되었던 이메일에 인증번호를 보내주는 형식입니다.
            String email = (String) values.get("email");
            if (results.equals("right email")) {
                MailSender Sender = new MailSender("ykhykh3587@gmail.com", "qexjxbdiizsoqwyj");
                Toast.makeText(FindActivity.this, results, Toast.LENGTH_SHORT).show();
                try {
                    int[] value = new int[4];
                    int im = 0;
                    int wait = 1000;
                    for (int a = 0; a < 4; a++) {
                        for (int i = 0; i < 100; i++) {
                            value[a] = rand.nextInt(10);
                            if (value[0] == 0)
                                value[0]++;
                        }
                    }
                    for (int b = 0; b < 4; b++) {
                        im = value[b] * wait;
                        wait = wait / 10;
                        emailcode += im;
                    }
                    Sender.sendMail(
                            "[ Oishi 인증번호 ]",
                            "\n\n 안녕하세요! Oishi입니다.\n 당신의 인증번호는 [" + emailcode + "] 입니다.",
                            "ykhykh3587@gamil.com",
                            "" + email + ""
                    );
                    asyncDialog.dismiss();
                    Toast.makeText(FindActivity.this, "인증번호를 전송했습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FindActivity.this, AuthenticationActivity.class);
                    intent.putExtra("key", emailcode);
                    intent.putExtra("type", type);
                    intent.putExtra("email", email);
                    startActivity(intent);
                    FindActivity.this.finish();
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
            } else {
                asyncDialog.dismiss();
                Toast.makeText(FindActivity.this, results, Toast.LENGTH_SHORT).show();
            }
        }
    }
}


*AuthenticationActivity*
public class AuthenticationActivity extends AppCompatActivity {

    MaterialEditText authentic_Text;
    Button confirm_Button;
    LinearLayout found_Content;
    TextView found_Text, login_Button, search_id_Button, search_password_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        Intent authentication = getIntent();
        final int key = authentication.getExtras().getInt("key");
        final String email = authentication.getExtras().getString("email");

        authentic_Text = findViewById(R.id.authentic_Text);
        confirm_Button = findViewById(R.id.confirm_Button);
        found_Content = findViewById(R.id.found_Content);
        found_Text = findViewById(R.id.found_Text);
        login_Button = findViewById(R.id.login_Button);
        search_id_Button = findViewById(R.id.search_id_Button);
        search_password_Button = findViewById(R.id.search_password_Button);

        final Intent[] intent = new Intent[2];
        intent[0] = new Intent(AuthenticationActivity.this, LoginActivity.class);
        intent[1] = new Intent(AuthenticationActivity.this, FindActivity.class);

        //***********************************************************************************************
        //확인 버튼을 클릭하면 입력된 인증번호가 이메일에 보낸 인증번호와 맞는 지 검사를 합니다.
        confirm_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtAuthentic = authentic_Text.getText().toString();
                if (key == Integer.parseInt(txtAuthentic)) {

                    String url = "http://ykh3587.dothome.co.kr/showme.php";

                    ContentValues values = new ContentValues();
                    values.put("email", email);

                    BackgroundTask task = new BackgroundTask(url, values);
                    task.execute();

                    found_Content.setVisibility(View.VISIBLE);
                    Toast.makeText(AuthenticationActivity.this, "인증번호가 맞습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    found_Content.setVisibility(View.INVISIBLE);
                    Toast.makeText(AuthenticationActivity.this, "잘못된 인증번호입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent[0]);
                AuthenticationActivity.this.finish();
            }
        });

        search_id_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent[1].putExtra("key", getString(R.string.find_id));
                startActivity(intent[1]);
                AuthenticationActivity.this.finish();
            }
        });

        search_password_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent[1].putExtra("key", getString(R.string.find_password));
                startActivity(intent[1]);
                AuthenticationActivity.this.finish();
            }
        });
    }

    public class BackgroundTask extends AsyncTask<Void, Void, String> {
        ProgressDialog asyncDialog;

        String url;
        ContentValues values;

        BackgroundTask(String url, ContentValues values) {
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            asyncDialog = ProgressDialog.show(AuthenticationActivity.this, "Please Wait", null, true, true);
        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result;
        }

        //다운로드 중 프로그레스바 업데이트
        @Override
        protected void onProgressUpdate(Void ... voids) {
            super.onProgressUpdate(voids);
        }

        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);
            asyncDialog.dismiss();

            Intent authentication = getIntent();
            String type = authentication.getExtras().getString("type");

            try {
                JSONObject jsonObject = new JSONObject(results);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                String userid = null;
                String password = null;
                System.out.println(jsonArray);

                //***********************************************************************************************
                //userid와 password를 데이터베이스에서 가져와서 found_text에 입력해서 아이디 또는 비밀번호를 보여주도록 합니다.
                for(int i=0;i<jsonArray.length();i++) {
                    JSONObject c = jsonArray.getJSONObject(i);
                    userid = c.getString("userid");
                    password = c.getString("password");
                }
                if(Objects.equals(type, getString(R.string.find_id))) {
                    String txtFound = "ID : " + userid;
                    found_Text.setText(txtFound);
                }
                else if(Objects.equals(type, getString(R.string.find_password))) {
                    String txtFound = "PW : " + password;
                    found_Text.setText(txtFound);
                }
            } catch (Exception e) {
                Toast.makeText(AuthenticationActivity.this, results, Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }
}


*RegisterActivity*
public class RegisterActivity extends AppCompatActivity {

    MaterialEditText id_Text, password_Text, name_Text, email_Text, phone_Text;
    RadioGroup sex_RadioGroup;
    Button register_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        id_Text= findViewById(R.id.id_Text);
        password_Text= findViewById(R.id.password_Text);
        name_Text= findViewById(R.id.name_Text);
        email_Text= findViewById(R.id.email_Text);
        phone_Text= findViewById(R.id.phone_Text);

        sex_RadioGroup = findViewById(R.id.sex_RadioGroup);
        register_Button = findViewById(R.id.register_Button);

        register_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtId = id_Text.getText().toString();
                String txtPassword = password_Text.getText().toString();
                String txtName = name_Text.getText().toString();
                String txtEmail = email_Text.getText().toString();
                String txtPhone = phone_Text.getText().toString();

                //아이디, 비밀번호, 이름, 이메일, 핸드폰 번호 중 하나라도 공백일 경우
                if (TextUtils.isEmpty(txtId) || TextUtils.isEmpty(txtPassword) || TextUtils.isEmpty(txtName) || TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPhone)) {
                    Toast.makeText(RegisterActivity.this, "빈칸을 채워주세요.", Toast.LENGTH_SHORT).show();
                }
                //아이디, 비밀번호, 이름, 이메일, 핸드폰 번호 모두 입력 되어 있을 경우
                else {
                    int genderId = sex_RadioGroup.getCheckedRadioButtonId();
                    RadioButton selected_Gender = sex_RadioGroup.findViewById(genderId);
                    //성별 라디오버튼 체크 안했을 경우
                    if (selected_Gender == null) {
                        Toast.makeText(RegisterActivity.this, "성별을 선택해 주세요.", Toast.LENGTH_SHORT).show();
                    }
                    //성별까지 모두 다 입력되어 있을경우
                    else {
                        String selectGender = selected_Gender.getText().toString();
                        String url = "http://ykh3587.dothome.co.kr/register.php";

                        ContentValues values = new ContentValues();

                        values.put("userid", txtId);
                        values.put("username", txtName);
                        values.put("email", txtEmail);
                        values.put("password", txtPassword);
                        values.put("mobile", txtPhone);
                        values.put("gender", selectGender);

                        BackgroundTask task = new BackgroundTask(url, values);
                        task.execute();
                    }
                }
            }
        });
    }

    public class BackgroundTask extends AsyncTask<Void, Void, String> {
        ProgressDialog asyncDialog;

        String url;
        ContentValues values;

        BackgroundTask(String url, ContentValues values) {
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            asyncDialog = ProgressDialog.show(RegisterActivity.this, "Please Wait", null, true, true);
        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result;
        }

        //다운로드 중 프로그레스바 업데이트
        @Override
        protected void onProgressUpdate(Void ... voids) {
            super.onProgressUpdate(voids);
        }

        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);
            asyncDialog.dismiss();

            //register.php파일의 반환값이 "Successfully Registered"와 일치
            if (results.equals("Successfully Registered")) {
                Toast.makeText(RegisterActivity.this, "회원가입 완료!", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                RegisterActivity.this.finish();
            }
            //register.php파일의 반환값이 "Successfully Registered"와 불일치
            else {
                Toast.makeText(RegisterActivity.this, results, Toast.LENGTH_SHORT).show();
            }
        }
    }
}


*amricano*
물품선택 시 나오는 activity
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_americano);

        Button COUNT_DOWN = findViewById(R.id.count_down);
        Button COUNT_UP = findViewById(R.id.count_up);
        final TextView COUNT_NUMBER = findViewById(R.id.count_number);
        final TextView BASE_PRICE = findViewById(R.id.menu_base_price);
        final TextView TITLE = findViewById(R.id.title);
        final TextView Store_Title = findViewById(R.id.store_name_Text);
        final ImageView Food_Img = findViewById(R.id.menu_image);
        final Button Shopping_Basket = findViewById(R.id.put_shopping_basket);

        //***********************************************************************************************
        //FoodDetailActivity에서 가게이름, 음식이름, 음식가격, 음식 이미지, 음식유형을 받아서 그 값을 띄워줍니다.
        Intent intent = getIntent();
        FoodName = intent.getExtras().getString("foodname");
        StoreName = intent.getExtras().getString("storename");
        FoodPrice = intent.getExtras().getString("foodprice");
        FoodImg = intent.getExtras().getString("foodimg");
        Food_Type = intent.getExtras().getString("foodtype");
        TITLE.setText(FoodName);
        System.out.println(FoodName);
        Store_Title.setText(StoreName);
        BASE_PRICE.setText(FoodPrice);
        Food_Img.setImageResource(getResources().getIdentifier(FoodImg, "drawable", this.getPackageName()));

        //***********************************************************************************************
        //php에서 사용할 핸드폰의 고유번호인 Serial number의 값을 가져옵니다. 
        local = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        COUNT_NUMBER.setText("" +count+"");
        Context context = this;

        COUNT_UP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                COUNT_NUMBER.setText(String.format("%s", count));
            }
        });

        COUNT_DOWN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                if(count < 1)
                {count = 1;}

                COUNT_NUMBER.setText(String.format("%s", count));
            }
        });

        //***********************************************************************************************
        //장바구니 버튼을 클릭하면 http://ykh3587.dothome.co.kr/shopping_basket.php로 연결해서 값들을 데이터베이스에 저장합니다.
        Shopping_Basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url2 = "http://ykh3587.dothome.co.kr/shopping_basket.php";
                ContentValues values = new ContentValues();
                values.put("storename", StoreName);
                values.put("foodname", FoodName);
                values.put("foodprice", FoodPrice);
                values.put("count", count);
                values.put("local", local);
                BackgroundTask task2 = new BackgroundTask(url2, values);
                task2.execute();

                Intent intent = new Intent(getApplicationContext(), FoodDetailActivity.class);
                intent.putExtra("brand_name", StoreName);
                intent.putExtra("foodtype", Food_Type);
                startActivity(intent);

            }
        });

        review_List = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);

        //***********************************************************************************************
        //http://ykh3587.dothome.co.kr/read_review.php로 연결해서 데이터베이스에 저장된 리뷰들을 가져옵니다.
        String url = "http://ykh3587.dothome.co.kr/read_review.php";

        BackgroundTask task = new BackgroundTask(url, null);
        task.execute();

    }
    public class BackgroundTask extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        BackgroundTask(String url, ContentValues values) {
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result;
        }

        @Override
        protected void onProgressUpdate(Void ... voids) {
            super.onProgressUpdate(voids);
        }

        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);

            //***********************************************************************************************
            //http://ykh3587.dothome.co.kr/read_review.php로 연결해서 데이터베이스에서 가져온 리뷰들을 adapter와 item들을 
            // 이용해서 값들이 저장되고 recyclerview를 이용해서 그 값들을 보여지도록 합니다.
            Gson gson = new Gson();
            try {
                JSONObject jsonObject = new JSONObject(results);
                JSONArray jsonArray = jsonObject.getJSONArray("response");

                for(int i=0;i<jsonArray.length();i++) {
                    JSONObject c = jsonArray.getJSONObject(i);
                    String uid = c.getString(TAG_UID);
                    String content = c.getString(TAG_CONTENT);
                    String rating = c.getString(TAG_RATING);
                    String time = c.getString(TAG_TIME);

                    HashMap<String,String> persons = new HashMap<>();

                    persons.put(TAG_UID,uid);
                    persons.put(TAG_CONTENT,content);
                    persons.put(TAG_RATING, rating);
                    persons.put(TAG_TIME, time);

                    review_List.add(persons);
/*


                    adapter.addItem(new MenuSortItem(uid, name,content));

                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new MenuSortItemLayoutManager(mContext));*/
                }

                ReviewItemAdapter adapter = new ReviewItemAdapter(mContext);

                // 어댑터 생성, R.layout.list_item : Layout ID
                for( int i = 0; i < review_List.size(); i++ ){

                    HashMap<String,String> hashMap = review_List.get(i);
                    adapter.addItem(new ReviewItem(hashMap.get(TAG_UID), hashMap.get(TAG_CONTENT), hashMap.get(TAG_RATING), hashMap.get(TAG_TIME)));
                   //System.out.println(hashMap.get(TAG_UID), hashMap.get(TAG_CONTENT), hashMap.get(TAG_RATING), hashMap.get(TAG_TIME));
                }

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new ReviewLayoutManager(mContext));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                store_title = data.getStringExtra("store_title");
            }
        }
    }
}


*Purchase_pageActivity*
public class Purchase_Page extends AppCompatActivity {

    String phone_number, local;

    RelativeLayout PURCHASE_BILL, PURCHASE_BILL2, PURCHASE_BILL3;
    Button PURCHASE;
    Button ALTER_NUMBER;
    Button ALTER_PURCHASE;
    EditText DETAIL_ADDRESS;
    TextView PHONE_NUMBER, ADDRESS, VIEW_PURCHASE;
    TextView PURCHASE_SOLUTION, TOTALPRICE, TOTALPRICE_AND_ALPHA;
    private static final String TAG_PHONENUMBER = "mobile";
    private static final String TAG_LOCATION = "location";
    private static final String TAG_TOTALSUM = "totalsum";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase__page);

        DETAIL_ADDRESS = findViewById(R.id.detail_address);
        TOTALPRICE = findViewById(R.id.total_price);
        TOTALPRICE_AND_ALPHA = findViewById(R.id.total_price_and_alpha);
        PURCHASE_BILL = findViewById(R.id.purchase_bill);
        PURCHASE_BILL2 = findViewById(R.id.purchase_bill2);
        PURCHASE_BILL3 = findViewById(R.id.purchase_bill3);
        PURCHASE = findViewById(R.id.next_purchase);
        ALTER_NUMBER = findViewById(R.id.number_alter);
        ALTER_PURCHASE = findViewById(R.id.purchase_alter);
        PHONE_NUMBER = findViewById(R.id.phone_number);
        PURCHASE_SOLUTION = findViewById(R.id.purchase_solution);
        ADDRESS = findViewById(R.id.address);
        VIEW_PURCHASE = findViewById(R.id.view_purchase);

        phone_number = PHONE_NUMBER.getText().toString();

        PURCHASE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edittext = DETAIL_ADDRESS.getText().toString();
                String to = TOTALPRICE.getText().toString();
                if(edittext.getBytes().length <= 0){
                    Toast.makeText(getApplicationContext(),"상세주소를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if(ADDRESS.getText().toString() == "null"){
                    Toast.makeText(getApplicationContext(),"주소 정보가 없습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), SettingAddressActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if(to.getBytes().length <= 0){
                    Toast.makeText(getApplicationContext(),"결제금액을 눌러 확인해주세요!\n 또는 선택하신 물품이 없습니다.\n장바구니에 물품을 넣어주세요!", Toast.LENGTH_SHORT).show();
                }

                //***********************************************************************************************
                //http://ykh3587.dothome.co.kr/remove_user_info.php로 연결해서 데이터베이스에 저장된 사용자의 장바구니 물품들을 삭제합니다.
                else {
                    Toast.makeText(getApplicationContext(), "결제 완료", Toast.LENGTH_SHORT).show();
                    String url = "http://ykh3587.dothome.co.kr/remove_user_info.php";
                    Context context = getApplicationContext();
                    local = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                    ContentValues values = new ContentValues();
                    values.put("local", local);
                    BackgroundTask2 task = new BackgroundTask2(url, values);
                    task.execute();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


        ALTER_NUMBER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Phone_number_alter.class);
                intent.putExtra("present_number", phone_number);
                startActivityForResult(intent, 1);
            }
        });

        ALTER_PURCHASE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Purchase_alter.class);
                startActivityForResult(intent, 2);
            }
        });

        //***********************************************************************************************
        //http://ykh3587.dothome.co.kr/loadtotalsum.php로 연결해서 데이터베이스에 저장된 사용자가 선택했던
        // 장바구니에서 선택했던 값들의 전체 값을 가져와 보여주도록 합니다.
        VIEW_PURCHASE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    PURCHASE_BILL.setVisibility(View.VISIBLE);
                    PURCHASE_BILL2.setVisibility(View.VISIBLE);
                    PURCHASE_BILL3.setVisibility(View.VISIBLE);
                    VIEW_PURCHASE.setText("결제금액");
                String url = "http://ykh3587.dothome.co.kr/loadtotalsum.php";
                Context context = getApplicationContext();
                local = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                ContentValues values = new ContentValues();
                values.put("local", local);
                BackgroundTask2 task = new BackgroundTask2(url, values);
                task.execute();
            }
        });
        //***********************************************************************************************
        //http://ykh3587.dothome.co.kr/loaduser.php로 연결해서 사용자의 핸드폰 Serial number를 보내서
        // users_table에 저장된 전화번호와 주소를 가져옵니다.
        String url = "http://ykh3587.dothome.co.kr/loaduser.php";
        Context context = getApplicationContext();
        local = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        ContentValues values = new ContentValues();
        values.put("local", local);
        BackgroundTask task = new BackgroundTask(url, values);
        task.execute();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                String result = data.getStringExtra("alter_phone_number");
                PHONE_NUMBER.setText(result);
            }
        }

        else if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                String result = data.getStringExtra("purchase");
                PURCHASE_SOLUTION.setText(result);
            }
        }
    }
    public class BackgroundTask extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        BackgroundTask(String url, ContentValues values) {
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result;
        }

        @Override
        protected void onProgressUpdate(Void ... voids) {
            super.onProgressUpdate(voids);
        }

        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);

            try {
                JSONObject jsonObject = new JSONObject(results);
                JSONArray jsonArray = jsonObject.getJSONArray("response");

                String location = ((JSONObject) jsonArray.get(0)).getString(TAG_LOCATION);
                String phonenumber = ((JSONObject) jsonArray.get(0)).getString(TAG_PHONENUMBER);

                ADDRESS.setText(location);
                PHONE_NUMBER.setText(phonenumber);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class BackgroundTask2 extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        BackgroundTask2(String url, ContentValues values) {
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result;
        }

        @Override
        protected void onProgressUpdate(Void ... voids) {
            super.onProgressUpdate(voids);
        }

        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);

            try {
                JSONObject jsonObject = new JSONObject(results);
                JSONArray jsonArray = jsonObject.getJSONArray("response");

                String totalsum = ((JSONObject) jsonArray.get(0)).getString(TAG_TOTALSUM);

                TOTALPRICE.setText(totalsum+"원");

                TOTALPRICE_AND_ALPHA.setText((Integer.parseInt(totalsum) + 2000) + "원");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


*Shopping_basket*
public class Shopping_basket extends AppCompatActivity {
    PurchaseRecyclerView recyclerView;
    public PurchaseItemAdapter adapter;
    PurchaseLayoutManager layout;
    String local;
    public int totalsum = 0;
    TextView total_sum, more;
    RadioButton delevery, packing;
    Button nextpage;
    public String foodname, foodprice, count;
    private static final String TAG_FOODNAME = "foodname";
    private static final String TAG_FOODPRICE = "foodprice";
    private static final String TAG_COUNT = "count";
    ArrayList<HashMap<String, String>> review_List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_basket);
        more = findViewById(R.id.more);
        delevery = findViewById(R.id.deliverybutton);
        nextpage = findViewById(R.id.next_purchase);
        packing = findViewById(R.id.packingbutton);
        total_sum = findViewById(R.id.total_price);
        adapter = new PurchaseItemAdapter(getApplicationContext());
        recyclerView = findViewById(R.id.order_list);
        review_List = new ArrayList<HashMap<String,String>>();



        //***********************************************************************************************
        //http://ykh3587.dothome.co.kr/read_shopping_basket.php로 연결해서 데이터베이스에 저장된 사용자가 선택했던
        // 장바구니에서 선택했던 값들의 전체 값을 가져와 보여주도록 합니다.
        // 품목 수량 버튼을 클릭하면 그것에 따른 반응을 하도록 구현했습니다.
        String url = "http://ykh3587.dothome.co.kr/read_shopping_basket.php";
        Context context = getApplicationContext();
        local = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        ContentValues values = new ContentValues();
        values.put("local", local);
        System.out.println(local);
        BackgroundTask task = new BackgroundTask(url, values);
        task.execute();

        delevery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                packing.setChecked(false);
            }
        });

        packing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delevery.setChecked(false);
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        nextpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(delevery.isChecked() == false && packing.isChecked() == false)
                {
                    Toast.makeText(Shopping_basket.this, "배달 혹은 포장을 선택해주세요.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), Purchase_Page.class);
                    startActivity(intent);
                }
            }
        });
}

    public class BackgroundTask extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        BackgroundTask(String url, ContentValues values) {
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result;
        }

        @Override
        protected void onProgressUpdate(Void ... voids) {
            super.onProgressUpdate(voids);
        }

        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);

            Gson gson = new Gson();
            try {
                JSONObject jsonObject = new JSONObject(results);
                JSONArray jsonArray = jsonObject.getJSONArray("response");

                for(int i=0;i<jsonArray.length();i++) {
                    JSONObject c = jsonArray.getJSONObject(i);
                    foodname = c.getString(TAG_FOODNAME);
                    foodprice = c.getString(TAG_FOODPRICE);
                    count = c.getString(TAG_COUNT);

                    HashMap<String,String> persons = new HashMap<String,String>();

                    persons.put(TAG_FOODNAME, foodname);
                    persons.put(TAG_FOODPRICE, foodprice);
                    persons.put(TAG_COUNT, count);

                    review_List.add(persons);
                }

                // 어댑터 생성, R.layout.list_item : Layout ID
                for( int i = 0; i < review_List.size(); i++ ){

                    HashMap<String,String> hashMap = review_List.get(i);
                    adapter.addItem(new PurchaseItem(hashMap.get(TAG_FOODNAME), hashMap.get(TAG_FOODPRICE), hashMap.get(TAG_COUNT)));
                    System.out.println(hashMap.get(TAG_FOODNAME));
                    System.out.println(hashMap.get(TAG_FOODPRICE));
                    System.out.println(hashMap.get(TAG_COUNT));


                }
                recyclerView.setHasFixedSize(true);

                layout = new PurchaseLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(layout);

                recyclerView.setAdapter(adapter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setTotalPriceText(int Total_Price) {
        //가게 최소주문금액
        int index = 0;
        int[] total_price_array = null;
        total_price_array[index] = Total_Price / 1000;

        while(true) {
            if (total_price_array[index] < 1000) {
                total_price_array[index] = Total_Price % 1000;
                total_price_array[index+1] = Total_Price / 1000;
                break;
            }
            else {
                total_price_array[index] = Total_Price % 1000;
                Total_Price = Total_Price / 1000;
                total_price_array[index+1] = Total_Price / 1000;
            }
            index++;
        }
        StringBuilder total_price_text = null;

        for(int i=total_price_array.length ; i > 0 ; i--) {
            if(i==1) {
                if(total_price_array[i - 1] < 100) {
                    if(total_price_array[i - 1] < 10) {
                        total_price_text.append("0").append(total_price_array[i - 1]).append("원");
                    }
                    else {
                        total_price_text.append("00").append(total_price_array[i - 1]).append("원");
                    }
                }
                else {
                    total_price_text.append(total_price_array[i - 1]).append("원");
                }
            }
            else {
                if(total_price_array[i - 1] < 100) {
                    if(total_price_array[i - 1] < 10) {
                        total_price_text.append("0").append(total_price_array[i - 1]).append(",");
                    }
                    else {
                        total_price_text.append("00").append(total_price_array[i - 1]).append(",");
                    }
                }
                else {
                    total_price_text.append(total_price_array[i - 1]).append(",");
                }
            }
        }
        //주문 리스트의 총합 지정하기
        //total_price.setText(total_price_text);
    }
}


*ReviewFragment*
public class ReviewFragment extends Fragment {
    public ReviewItemAdapter adapter;
    ReviewRecyclerView recyclerView;
    ReviewLayoutManager layout;

    private static final String TAG_UID = "id";
    private static final String TAG_CONTENT ="content";
    private static final String TAG_RATING = "rating";
    private static final String TAG_TIME = "present";
    ArrayList<HashMap<String, String>> review_List;

    public ReviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_review, container, false);

        adapter = new ReviewItemAdapter(getActivity());

        recyclerView = (ReviewRecyclerView) view.findViewById(R.id.recycler_view);

        review_List = new ArrayList<HashMap<String,String>>();ㅍ


        //***********************************************************************************************
        //http://ykh3587.dothome.co.kr/read_shopping_basket.php로 연결해서 데이터베이스에 저장된 사용자가 선택했던
        // 장바구니에서 선택했던 값들의 전체 값을 가져와 보여주도록 합니다.
        // 품목 수량 버튼을 클릭하면 그것에 따른 반응을 하도록 구현했습니다.
        String url = "http://ykh3587.dothome.co.kr/read_review.php";


        BackgroundTask task = new BackgroundTask(url, null);
        task.execute();

        Button register = (Button) view.findViewById(R.id.register_review);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PopupActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                String name = data.getStringExtra("name");
                String content = data.getStringExtra("content");
                String url = data.getStringExtra("url");
                item.add(new Item(name, url, content));
            }
        }
    }*/

    public class BackgroundTask extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        BackgroundTask(String url, ContentValues values) {
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result;
        }

        @Override
        protected void onProgressUpdate(Void ... voids) {
            super.onProgressUpdate(voids);
        }

        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);

            Gson gson = new Gson();
            try {
                JSONObject jsonObject = new JSONObject(results);
                JSONArray jsonArray = jsonObject.getJSONArray("response");

                for(int i=0;i<jsonArray.length();i++) {
                    JSONObject c = jsonArray.getJSONObject(i);
                    String uid = c.getString(TAG_UID);
                    String content = c.getString(TAG_CONTENT);
                    String rating = c.getString(TAG_RATING);
                    String time = c.getString(TAG_TIME);

                    HashMap<String,String> persons = new HashMap<String,String>();

                    persons.put(TAG_UID,uid);
                    persons.put(TAG_CONTENT,content);
                    persons.put(TAG_RATING, rating);
                    persons.put(TAG_TIME, time);

                    review_List.add(persons);

                }

                // 어댑터 생성, R.layout.list_item : Layout ID
                for( int i = 0; i < review_List.size(); i++ ){

                    HashMap<String,String> hashMap = review_List.get(i);
                    adapter.addItem(new ReviewItem(hashMap.get(TAG_UID), hashMap.get(TAG_CONTENT), hashMap.get(TAG_RATING), hashMap.get(TAG_TIME)));
                    System.out.println(hashMap.get(TAG_UID));
                }
                recyclerView.setHasFixedSize(true);

                layout = new ReviewLayoutManager(getActivity());
                recyclerView.setLayoutManager(layout);

                recyclerView.setAdapter(adapter);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

*DetailMenuFragment*
public class DetailMenuFragment extends Fragment {
    detailmenuRecyclerView recyclerView;
    public detailmenuItemAdapter adapter;
    detailmenuLayoutManager layout;
    public String Food_Type, Brand_Name;
    private static final String TAG_FOODNAME = "Child_Name";
    private static final String TAG_FOODPRICE = "Child_Price";
    private static final String TAG_FOODIMG = "Child_Img";
    ArrayList<HashMap<String, String>> review_List;

    public DetailMenuFragment(String brand_name, String food_type)
    {
        Brand_Name = brand_name;
        Food_Type = food_type;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_menu, container, false);
        adapter = new detailmenuItemAdapter(getActivity(), Brand_Name, Food_Type);
        recyclerView = view.findViewById(R.id.detail_recyclerview);
        review_List = new ArrayList<HashMap<String,String>>();

        //***********************************************************************************************
        //http://ykh3587.dothome.co.kr/" + Food_Type + "_detail.php에서 FoodDetailActivity에서 받아온 Food_Type을 이용해서
        //php를 선택한 가게에 있는 음식이름들과 가격, 이미지들을 가져와서 recyclerview로 보여지도록 합니다. 
        String url = "http://ykh3587.dothome.co.kr/" + Food_Type + "_detail.php";
        ContentValues values = new ContentValues();
        values.put("storename", Brand_Name);
        System.out.println(url);
        System.out.println(Brand_Name);
        BackgroundTask task = new BackgroundTask(url, values);
        task.execute();

        return view;
    }


    public class BackgroundTask extends AsyncTask<Void, Void, String> {

        String url;
        ContentValues values;

        BackgroundTask(String url, ContentValues values) {
            this.url = url;
            this.values = values;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(Void... params) {
            String result;
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result;
        }

        @Override
        protected void onProgressUpdate(Void ... voids) {
            super.onProgressUpdate(voids);
        }

        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);

            Gson gson = new Gson();
            try {
                JSONObject jsonObject = new JSONObject(results);
                JSONArray jsonArray = jsonObject.getJSONArray("response");

                for(int i=0;i<jsonArray.length();i++) {
                    JSONObject c = jsonArray.getJSONObject(i);
                    String foodname = c.getString(TAG_FOODNAME);
                    String foodprice = c.getString(TAG_FOODPRICE);
                    String foodimg = c.getString(TAG_FOODIMG);

                    HashMap<String,String> persons = new HashMap<String,String>();

                    persons.put(TAG_FOODNAME, foodname);
                    persons.put(TAG_FOODPRICE, foodprice);
                    persons.put(TAG_FOODIMG, foodimg);

                    review_List.add(persons);
                }

                // 어댑터 생성, R.layout.list_item : Layout ID
                for( int i = 0; i < review_List.size(); i++ ){

                    HashMap<String,String> hashMap = review_List.get(i);
                    adapter.addItem(new detailmenuItem(hashMap.get(TAG_FOODNAME), hashMap.get(TAG_FOODPRICE), hashMap.get(TAG_FOODIMG)));
                    System.out.println(hashMap.get(TAG_FOODNAME));
                    System.out.println(hashMap.get(TAG_FOODPRICE));
                    System.out.println(hashMap.get(TAG_FOODIMG));
                }
                recyclerView.setHasFixedSize(true);

                layout = new detailmenuLayoutManager(getActivity());
                recyclerView.setLayoutManager(layout);

                recyclerView.setAdapter(adapter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

**FoodBrandAdapter**


public class FoodBrandAdapter extends BaseAdapter {
    //FoodBrandAdapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<FoodBrandListViewItem> foodBrandListViewItems = new ArrayList<>();

    //FoodBrandAdapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return foodBrandListViewItems.size();
    }

    //position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();

        //"listview_food_brand_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_food_brand_item, parent, false);
        }

        //화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView food_brand_logo = convertView.findViewById(R.id.food_brand_logo);
        TextView food_brand_name = convertView.findViewById(R.id.food_brand_name);
        TextView food_brand_representative_menu = convertView.findViewById(R.id.food_brand_representative_menu);
        TextView food_brand_order_call = convertView.findViewById(R.id.food_brand_order_call);

        //Data Set(foodBrandListViewItems)에서 position에 위치한 데이터 참조 획득
        FoodBrandListViewItem foodBrandListViewItem = foodBrandListViewItems.get(position);
        System.out.println(foodBrandListViewItem.getMain_Store_Icon());
        //아이템 내 각 위젯에 데이터 반영
        food_brand_logo.setImageResource(context.getResources().getIdentifier(foodBrandListViewItem.getMain_Store_Icon(), "drawable", context.getPackageName()));
        food_brand_name.setText(foodBrandListViewItem.getMain_Store_Name());
        food_brand_representative_menu.setText(foodBrandListViewItem.getMain_Store_menu());
        food_brand_order_call.setText(foodBrandListViewItem.getMain_Store_Phone_Number());

        return convertView;
    }

    //지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) { return position; }

    //지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) { return foodBrandListViewItems.get(position); }

    //아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String name, String order_call, String logo, String representative_menu) {
        FoodBrandListViewItem item = new FoodBrandListViewItem();

        item.setMain_Store_Name(name);
        item.setMain_Store_Phone_Number(order_call);
        item.setMain_Store_Icon(logo);
        item.setMain_Store_menu(representative_menu);

        foodBrandListViewItems.add(item);
    }
}


**FoodBrandListFragment**


public class FoodBrandListFragment extends ListFragment {
    private FoodBrandAdapter adapter;
    public String Food_Type;
    public String Food_Type2;

    //ListFragment 생성자
    public FoodBrandListFragment(String food_type, String food_Type2) {
        Food_Type = food_type;
        Food_Type2 = food_Type2;
    }

    //ListView 생성 처리
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String url = "http://ykh3587.dothome.co.kr/food_brand_list.php";

        ContentValues values = new ContentValues();
        values.put("Food_Type", Food_Type);

        BackgroundTask task = new BackgroundTask(url, values);
        task.execute();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //ListView 클릭 이벤트 처리
    @Override
    public void onListItemClick (ListView listView, View view, int position, long id) {
        // get TextView's Text.
        FoodBrandListViewItem item = (FoodBrandListViewItem) listView.getItemAtPosition(position);

        String food_brand_name = item.getMain_Store_Name();

        //use item data.
        Intent intent = new Intent(getActivity(), FoodDetailActivity.class);
        intent.putExtra("brand_name", food_brand_name);
        intent.putExtra("foodtype", Food_Type2);
        startActivity(intent);
    }

    //ListFragment Item추가
    public void addItem(String name, String order_call, String logo, String representative_menu) {
        adapter.addItem(name, order_call, logo, representative_menu) ;
    }

    //AsyncTask 스레드 동작 함수
    public class BackgroundTask extends AsyncTask<Void, Void, String> {
        ProgressDialog asyncDialog;

        String url;
        ContentValues values;

        //AsyncTask 스레드 생성자
        BackgroundTask(String url, ContentValues values) {
            this.url = url;
            this.values = values;
        }

        //UI 동작 이전 초기화 단계
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //백그라운드 동작 대기 UI를 ProgressDialog로 사용함
            asyncDialog = ProgressDialog.show(getActivity(), "Please Wait", null, true, true);
            adapter = new FoodBrandAdapter();
        }

        //백그라운드 동작 실행
        @Override
        protected String doInBackground(Void... params) {
            String result;
            //HTTP접속 파일 생성 후 URL, 매개변수 전달 후 값 반환
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values);
            return result;
        }

        //주기적인 UI 동작 업데이트
        @Override
        protected void onProgressUpdate(Void ... voids) {
            super.onProgressUpdate(voids);
        }

        //백그라운드 동작 수행 이후 결과 값 사용
        @Override
        protected void onPostExecute(String results) {
            super.onPostExecute(results);
            asyncDialog.dismiss();

            setListAdapter(adapter);

            //Gson : Json객체를 생성자 파일의 형태에 맞게끔 변환시켜줌
            Gson gson = new Gson();
            try {
                JSONObject jsonObject = new JSONObject(results);
                JSONArray jsonArray = jsonObject.getJSONArray("response");

                int index = 0;
                while(index < jsonArray.length()) {
                    //변환
                    FoodBrandListViewItem foodBrandListViewItem = gson.fromJson(jsonArray.get(index).toString(), FoodBrandListViewItem.class);
                    //어뎁터에 추가
                    adapter.addItem(foodBrandListViewItem.getMain_Store_Name(), foodBrandListViewItem.getMain_Store_Phone_Number(), foodBrandListViewItem.getMain_Store_Icon(), foodBrandListViewItem.getMain_Store_menu());
                    index++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


**FoodBrandListViewItem**


public class FoodBrandListViewItem {
    //가게 이름
    private String Main_Store_Name;
    //가게 전화번호
    private String Main_Store_Phone_Number;
    //가게 이미지
    private String Main_Store_Icon;
    //가게 대표 메뉴
    private String Main_Store_menu;
    //가게 찜한 가게
    private int Main_Store_Favorite;
    //가게 최소 주문 가게
    private int Main_Store_Min_Price;
    //가게 배달 시간
    private String Main_Store_Delivery_Time;
    //가게 배달 팁
    private int Main_Store_Delivery_Tip;
    //가게 주문 수
    private int Main_Store_Order_Number;
    //가게 운영시간
    private String Main_Store_Running_Time;
    //가게 휴무일
    private String Main_Store_Holiday;
    //가게 주소
    private String Main_Store_Detail_Address;
    //가게 별점
    private float Main_Store_Rating;
    //가게 리뷰
    private int Main_Store_Review;

    /*
     ListView에 사용되는 브랜드 이미지, 이름, 전화번호, 대표메뉴는 getter and setter를 사용하였고
     나머지 속성들은 getter를 사용하여 하나의 가게 데이터에서 값을 불러올수있게 사용됨
     */

    public String getMain_Store_Name() {
        return Main_Store_Name;
    }

    public void setMain_Store_Name(String main_Store_Name) {
        Main_Store_Name = main_Store_Name;
    }

    public String getMain_Store_Phone_Number() {
        return Main_Store_Phone_Number;
    }

    public void setMain_Store_Phone_Number(String main_Store_Phone_Number) {
        Main_Store_Phone_Number = main_Store_Phone_Number;
    }

    public String getMain_Store_Icon() {
        return Main_Store_Icon;
    }

    public void setMain_Store_Icon(String main_Store_Icon) {
        Main_Store_Icon = main_Store_Icon;
    }

    public String getMain_Store_menu() {
        return Main_Store_menu;
    }

    public void setMain_Store_menu(String main_Store_menu) {
        Main_Store_menu = main_Store_menu;
    }

    public int getMain_Store_Favorite() {
        return Main_Store_Favorite;
    }

    public int getMain_Store_Min_Price() {
        return Main_Store_Min_Price;
    }

    public String getMain_Store_Delivery_Time() {
        return Main_Store_Delivery_Time;
    }

    public int getMain_Store_Delivery_Tip() {
        return Main_Store_Delivery_Tip;
    }

    public int getMain_Store_Order_Number() {
        return Main_Store_Order_Number;
    }

    public String getMain_Store_Running_Time() {
        return Main_Store_Running_Time;
    }

    public String getMain_Store_Holiday() {
        return Main_Store_Holiday;
    }

    public String getMain_Store_Detail_Address() {
        return Main_Store_Detail_Address;
    }

    public float getMain_Store_Rating() {
        return Main_Store_Rating;
    }

    public int getMain_Store_Review() {
        return Main_Store_Review;
    }
}

</code></pre>



**Splash Activity**  

**데이터베이스**   
![image](https://user-images.githubusercontent.com/62701551/85317351-378c0100-b4f9-11ea-837a-3123902bb8e9.png)   

phpMyAdmin은 MySQL을 웹 상에서 관리할 목적으로 PHP로 작성한 오픈 소스 도구, 즉 MySQL Client 툴이다. 데이터베이스, 테이블, 필드, 열의 작성, 수정, 삭제, SQL 상태 실행, 사용자 및 사용 권한 관리 등의 다양한 작업을 웹 상에서 편리하게 수행할 수 있다.    
