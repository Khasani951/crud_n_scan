<?php

    include '../../config/connection.php';

    if($_SERVER['REQUEST_METHOD'] == 'POST') {
        $email = $_POST['email'];
        $password = $_POST['password'];
        $mc_no = $_POST['mc_no'];

        $cekuser = mysqli_query($_AUTH, "SELECT COUNT(*) 'user_exist' FROM tbl_user WHERE email = '$email' AND password = md5('$password');");
        $userexist = mysqli_fetch_assoc($cekuser);

        if ($userexist['user_exist'] > 0) {
            $cekmc_no = mysqli_query($_AUTH, "SELECT COUNT(*) 'mc_exist' FROM tbl_machine WHERE mc_no = '$mc_no';");
            $mc_noexist = mysqli_fetch_assoc($cekmc_no);

            if ($mc_noexist['mc_exist'] > 0 ) {
              $response["message"] = trim("Nomor Mesin ada di dalam database, gunakan Nomor Mesin baru!");
              $response["code"] = 408;
              $response["status"] = false;
            } else {
              $die_height = $_POST['die_height'];
              $spm = $_POST['spm'];
              $timing_id = $_POST['timing_id'];
              $vorl_role_id = $_POST['vorl_role_id'];

              $createnew = mysqli_query($_AUTH, "INSERT INTO tbl_machine (mc_no, die_height, spm, timing_id, vorl_role_id) VALUES ('$mc_no', '$die_height', '$spm', '$timing_id', '$vorl_role_id');");

              $fetch_newmesin = mysqli_query($_AUTH, "SELECT id, mc_no, die_height, spm, timing_id, vorl_role_id FROM tbl_machine WHERE mc_no = '$mc_no';");

              $response["message"] = trim("Data mesin berhasil ditambahkan");
              $response["code"] = 201;
              $response["status"] = true;
              $response["newmesin"] = array();

              while($row = mysqli_fetch_array($fetch_newmesin)) {
                $data = array();

                $data['id'] = $row['id'];
                $data['mc_no'] = $row['mc_no'];
                $data['die_height'] = $row['die_height'];
                $data['spm'] = $row['spm'];
                $data['timing_id'] = $row['timing_id'];
                $data['vorl_role_id'] = $row['vorl_role_id'];

                array_push($response['newmesin'], $data);
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