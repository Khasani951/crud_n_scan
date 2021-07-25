<?php

    include '../config/connection.php';

    if($_SERVER['REQUEST_METHOD'] == 'POST') {
        $search_email = $_POST['email']; 

        $email_isexist = mysqli_query($_AUTH, "SELECT COUNT(email) 'email_exist' FROM tbl_user WHERE email = '$search_email';");
        $result_emailsearch = mysqli_fetch_assoc($email_isexist);

        if ($result_emailsearch['email_exist'] == 0) {
            $fullname = $_POST['full_name'];
            $nik = $_POST['nik'];
            $password = $_POST['password'];
            $role = $_POST['password'];

            // Proses Register
            $register = mysqli_query($_AUTH, "INSERT INTO tbl_user (full_name, nik, email, password, role) VALUES ('$fullname', '$nik', '$search_email', md5('$password'), '$role');");

            // Periksa User Sudah Masuk ke Database
            $cek_user = mysqli_query($_AUTH, "SELECT COUNT(email) 'user_has_exist' FROM tbl_user WHERE email = '$search_email';");
            $get_cekuser = mysqli_fetch_assoc($cek_user);

            if ($get_cekuser['user_has_exist'] >= 0) {
                $fetch_regist = mysqli_query($_AUTH, "SELECT id, full_name, nik, email, password, role FROM tbl_user WHERE email = '$search_email';");
                
                $response["message"] = "User dengan email " .  $search_email . " berhasil ditambahkan kedalam database";
                $response["code"] = 201;
                $response["status"] = true;
                $response["newregist"] = array();

                while($row = mysqli_fetch_array($fetch_regist)) {
                    $data = array();

                    $data['id'] = $row['id'];
                    $data['full_name'] = $row['full_name'];
                    $data['nik'] = $row['nik'];
                    $data['email'] = $row['email'];
                    $data['role'] = $row['role'];

                    array_push($response['newregist'], $data);
                }

                echo json_encode($response);
            }

        } else {
            $response["message"] = "Imposible / tidak memungkinkan menambahkan data user ini kedalam database, karena data tersedia didatabase!, gunakan email lain.";
            $response["code"] = 405;
            $response["status"] = false;
            echo json_encode($response);
        }

    } else {
        $response["message"] = trim("Oops! Sory, Request API ini membutuhkan parameter! Ubah menjadi POST.");
        $response["code"] = 400;
        $response["status"] = false;

        echo json_encode($response);
    }

?>