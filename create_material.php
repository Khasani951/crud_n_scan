<?php

    include '../../config/connection.php';

    if($_SERVER['REQUEST_METHOD'] == 'POST') {
        $email = $_POST['email'];
        $password = $_POST['password'];
        $tagmaterial = $_POST['tag_material'];

        $cekuser = mysqli_query($_AUTH, "SELECT COUNT(*) 'user_exist' FROM tbl_user WHERE email = '$email' AND password = md5('$password');");
        $userexist = mysqli_fetch_assoc($cekuser);

        if ($userexist['user_exist'] > 0) {

            $cekmaterial = mysqli_query($_AUTH, "SELECT COUNT(*) 'material_exist' FROM tbl_material WHERE tag_number = '$tagmaterial';");
            $materialexist = mysqli_fetch_assoc($cekmaterial);

            if ($materialexist['material_exist'] > 0) {
              $response["message"] = trim("Material ada di dalam database, gunakan tag number baru!");
              $response["code"] = 408;
              $response["status"] = false;
            } else {
              $beratmaterial = $_POST['berat'];
              $start = $_POST['start'];
              $finish = $_POST['finish'];
              $total_time = $_POST['total_time'];
              $result = $_POST['result'];

              $createnew = mysqli_query($_AUTH, "INSERT INTO tbl_material (berat, tag_number, start, finish, total_time, result) VALUES ('$beratmaterial', '$tagmaterial', '$start', '$finish', '$total_time', '$result');");

              $fetch_newmaterial = mysqli_query($_AUTH, "SELECT id, berat, tag_number, start, finish, total_time, result FROM tbl_material WHERE tag_number = '$tagmaterial';");

              $response["message"] = trim("Material berhasil ditambahkan");
              $response["code"] = 201;
              $response["status"] = true;
              $response["newmaterial"] = array();

              while($row = mysqli_fetch_array($fetch_newmaterial)) {
                $data = array();

                $data['id'] = $row['id'];
                $data['berat'] = $row['berat'];
                $data['tag_number'] = $row['tag_number'];
                $data['start'] = $row['start'];
                $data['finish'] = $row['finish'];
                $data['total_time'] = $row['total_time'];
                $data['result'] = $row['result'];

                array_push($response['newmaterial'], $data);
              }
            }

            echo json_encode($response);
        } else {
            $response["message"] = trim("Autentikasi gagal, Cek kembali user credential anda.");
            $response["code"] = 401;
            $response["status"] = false;
            echo json_encode($response);
        }
    } else {
        $response["message"] = trim("Oops! Sory, Request API ini membutuhkan parameter!. Ubah menjadi POST.");
        $response["code"] = 400;
        $response["status"] = false;

        echo json_encode($response);
    }

?>