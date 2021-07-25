<?php

    include '../config/connection.php';

    if($_SERVER['REQUEST_METHOD'] == 'POST') {
        $cek_email = $_POST['email'];
        $cek_password = $_POST['password'];

        $proseslogin = mysqli_query($_AUTH, "SELECT id, full_name, nik, email, role FROM tbl_user WHERE email = '$cek_email' AND password = MD5('$cek_password');");
        
        $getfieldlogin = mysqli_fetch_assoc($proseslogin);

        $existuser = mysqli_query($_AUTH, "SELECT COUNT(*) 'total' FROM tbl_user WHERE email = '$cek_email' AND password = MD5('$cek_password');");
        $totaldata = mysqli_fetch_assoc($existuser);

        if ($totaldata['total'] == 0) {
            $response["message"] = "Maaf, Anda gagal melakukan login kedalam aplikasi, silahkan cek user credensial anda!";
            $response["code"] = 404;
            $response["status"] = false;

            echo json_encode($response);
        } else {
            
            $response["message"] = "Congratulation! Anda berhasil login";
            $response["code"] = 200;
            $response["status"] = true;

            $response["data_user"] = [
              "id" => $getfieldlogin['id'],
              "full_name" => $getfieldlogin['full_name'],
              "nik" => $getfieldlogin['nik'],
              "email" => $getfieldlogin['email'],
              "role" => $getfieldlogin['role']
            ];
            
            echo json_encode($response);
        }
        
    } else {
        $response["message"] = trim("Oops! Sory, Request API ini membutuhkan parameter!. Ubah menjadi POST.");
        $response["code"] = 400;
        $response["status"] = false;

        echo json_encode($response);
    }

?>