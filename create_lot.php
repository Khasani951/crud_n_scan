<?php

    include '../../config/connection.php';

    if($_SERVER['REQUEST_METHOD'] == 'POST') {
        $email = $_POST['email'];
        $password = $_POST['password'];
        $lotno = $_POST['lot_no'];

        $cekuser = mysqli_query($_AUTH, "SELECT COUNT(*) 'user_exist' FROM tbl_user WHERE email = '$email' AND password = md5('$password');");
        $userexist = mysqli_fetch_assoc($cekuser);

        if ($userexist['user_exist'] > 0) {

            $ceklotno = mysqli_query($_AUTH, "SELECT COUNT(*) 'lotno_exist' FROM tbl_lot_no WHERE lot_no = '$lotno';");
            $lotnoexist = mysqli_fetch_assoc($ceklotno);

            if ($lotnoexist['lotno_exist'] > 0) {
              $response["message"] = trim("Lot no ada di dalam database, gunakan Lot baru!");
              $response["code"] = 408;
              $response["status"] = false;
            } else {
              $id_daily = $_POST['id_daily'];
              $qty = $_POST['qty'];
              $box = $_POST['box'];
              $total = $_POST['total'];

              $createnew = mysqli_query($_AUTH, "INSERT INTO tbl_lot_no (id_daily, lot_no, qty, box, total) VALUES ('$id_daily', '$lotno', '$qty', '$box', '$total');");

              $fetch_newlot = mysqli_query($_AUTH, "SELECT id, id_daily, lot_no, qty, box, total FROM tbl_lot_no WHERE lot_no = '$lotno';");

              $response["message"] = trim("Lot berhasil ditambahkan");
              $response["code"] = 201;
              $response["status"] = true;
              $response["newlot"] = array();

              while($row = mysqli_fetch_array($fetch_newlot)) {
                $data = array();

                $data['id'] = $row['id'];
                $data['id_daily'] = $row['id_daily'];
                $data['lot_no'] = $row['lot_no'];
                $data['qty'] = $row['qty'];
                $data['box'] = $row['box'];
                $data['total'] = $row['total'];

                array_push($response['newlot'], $data);
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