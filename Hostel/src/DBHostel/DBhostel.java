package DBHostel;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import Hostel.*;

public class DBhostel extends DBcore {

	public static final String[] TITLES = { "民宿編號", "民宿名稱", "民宿地址" };

	public void createhostel(Hostel hosData) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = makeConnection();
			String SQL = "Insert into BedandBreakfast(hostel_name,hostel_phone,hostel_address,hostel_server,hostel_payway,hostel_img,hostel_deposit,user_email) VALUES(?,?,?,?,?,?,?,?)";
			st = conn.prepareStatement(SQL);
			st.setString(1, hosData.gethostel_name());
			st.setString(2, hosData.gethostel_phone());
			st.setString(3, hosData.gethostel_address());
			st.setString(4, hosData.gethostel_server());
			st.setString(5, hosData.gethostel_payway());
			st.setString(6, hosData.gethostel_img());
			st.setString(7, hosData.gethostel_deposit());
			st.setString(8, hosData.getuser_email());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void updatehostel(Hostel hosData, String hostel_id) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = makeConnection();
			String SQL = "UPDATE BedandBreakfast SET hostel_phone = ?,hostel_server = ? ,hostel_payway = ? ,hostel_deposit = ? ,hostel_img = ? WHERE hostel_id = ?";
			st = conn.prepareStatement(SQL);
			st.setString(1, hosData.gethostel_phone());
			st.setString(2, hosData.gethostel_server());
			st.setString(3, hosData.gethostel_payway());
			st.setString(4, hosData.gethostel_deposit());
			st.setString(5, hosData.gethostel_img());
			st.setInt(6, Integer.parseInt(hostel_id));
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	public boolean isAvailable(Date date, int hostel_id) throws Exception {
		boolean status = true;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rec = null;
		try {
			conn = makeConnection();
			st = conn.prepareStatement(
					"SELECT * FROM Booking,Room,BedandBreakfast where order_date=? and BedandBreakfast.hostel_id=? and Booking.room_id = Room.room_id and Room.hostel_id = BedandBreakfast.hostel_id");
			st.setDate(1, date);
			st.setInt(2, hostel_id);
			rec = st.executeQuery();
			status = rec.next();

		} catch (Exception e) {
			throw e;
		} finally {
			if (rec != null) {
				rec.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return status;
	}

	public boolean isowner(String user_email) throws Exception {
		boolean status = true;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rec = null;
		try {
			conn = makeConnection();
			st = conn.prepareStatement("SELECT * FROM BedandBreakfast where user_email = ?");
			st.setString(1, user_email);
			rec = st.executeQuery();
			status = rec.next();
		} catch (Exception e) {
			throw e;
		} finally {
			if (rec != null) {
				rec.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return status;
	}

	public String getHostelDeposit(String hostel_id) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rec = null;
		String deposit = "";
		try {
			conn = makeConnection();
			st = conn.prepareStatement("SELECT * FROM BedandBreakfast where hostel_id = ?");
			st.setString(1, hostel_id);
			rec = st.executeQuery();
			while (rec.next()) {
				deposit = rec.getString("hostel_deposit");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rec != null) {
				rec.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return deposit;
	}

	public List<Hostel> getAllHostel() throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rec = null;
		List<Hostel> allHostel = new ArrayList<Hostel>();
		try {
			conn = makeConnection();
			st = conn.prepareStatement("SELECT * FROM BedandBreakfast");
			rec = st.executeQuery();
			while (rec.next()) {
				allHostel.add(getHostel(rec));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rec != null) {
				rec.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return allHostel;
	}

	public List<Hostel> getLocalHostel(String hostel_adderss) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rec = null;
		List<Hostel> localHostel = new ArrayList<Hostel>();
		try {
			conn = makeConnection();
			st = conn.prepareStatement("SELECT * FROM BedandBreakfast where hostel_address like ?");
			st.setString(1, "%" + hostel_adderss + "%");
			rec = st.executeQuery();
			while (rec.next()) {
				localHostel.add(getHostel(rec));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rec != null) {
				rec.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return localHostel;
	}

	public List<Hostel> getKeyHostel(String hostel_key) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rec = null;
		List<Hostel> keyHostel = new ArrayList<Hostel>();
		try {
			conn = makeConnection();
			st = conn.prepareStatement(
					"SELECT * FROM BedandBreakfast where hostel_address like ? or hostel_name like ?");
			st.setString(1, "%" + hostel_key + "%");
			st.setString(2, "%" + hostel_key + "%");
			rec = st.executeQuery();
			while (rec.next()) {
				keyHostel.add(getHostel(rec));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rec != null) {
				rec.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return keyHostel;
	}

	public List<Hostel> getHostel(String hostel_id) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rec = null;
		List<Hostel> hostel = new ArrayList<Hostel>();
		try {
			conn = makeConnection();
			st = conn.prepareStatement("SELECT * FROM BedandBreakfast where hostel_id = ?");
			st.setString(1, hostel_id);
			rec = st.executeQuery();
			while (rec.next()) {
				hostel.add(getHostel(rec));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rec != null) {
				rec.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return hostel;
	}

	public List<Hostel> getMyHostel(String user_email) throws Exception {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rec = null;
		List<Hostel> hostel = new ArrayList<Hostel>();
		try {
			conn = makeConnection();
			st = conn.prepareStatement("SELECT * FROM BedandBreakfast where user_email = ?");
			st.setString(1, user_email);
			rec = st.executeQuery();
			while (rec.next()) {
				hostel.add(getHostel(rec));
			}

		} catch (Exception e) {
			throw e;
		} finally {
			if (rec != null) {
				rec.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return hostel;
	}

	public Hostel getHostel(ResultSet rec) throws Exception {
		try {
			int hostel_id = rec.getInt("hostel_id");
			String hostel_name = rec.getString("hostel_name");
			String hostel_phone = rec.getString("hostel_phone");
			String hostel_address = rec.getString("hostel_address");
			String hostel_server = rec.getString("hostel_server");
			String hostel_payway = rec.getString("hostel_payway");
			String user_email = rec.getString("user_email");
			String hostel_deposit = rec.getString("hostel_deposit");
			String hostel_img = rec.getString("hostel_img");
			return new Hostel(hostel_id, hostel_name, hostel_phone, hostel_address, hostel_server, hostel_payway,
					user_email, hostel_deposit, hostel_img);
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean isrehostel(String hostel_adderss, String hostel_name) throws Exception {
		boolean status = true;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rec = null;
		try {
			conn = makeConnection();
			st = conn.prepareStatement("SELECT * FROM BedandBreakfast where hostel_address = ? or hostel_name = ?");
			st.setString(1, hostel_adderss);
			st.setString(2, hostel_name);
			rec = st.executeQuery();
			status = rec.next();
		} catch (Exception e) {
			throw e;
		} finally {
			if (rec != null) {
				rec.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return status;
	}
}
